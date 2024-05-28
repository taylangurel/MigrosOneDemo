package com.migrosone.MigrosOneDemo.service;

import com.migrosone.MigrosOneDemo.model.CourierEntry;
import com.migrosone.MigrosOneDemo.model.CourierInfoModel;
import com.migrosone.MigrosOneDemo.model.StoreInfoModel;
import com.migrosone.MigrosOneDemo.util.CourierTrackingUtil;
import com.migrosone.MigrosOneDemo.util.GeoUtil;
import com.migrosone.MigrosOneDemo.util.JsonReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class DemoService {

    private static HashMap<StoreInfoModel, List<CourierEntry>> within100MStores = new HashMap<>();
    List<StoreInfoModel> stores = JsonReader.readJsonFile();
    private CourierTrackingUtil courierTrackingUtil = new CourierTrackingUtil();

    private static void logCourierAndStoreDetails(CourierInfoModel courierInfoModel) {
        System.out.println("Courier: " + courierInfoModel);
        for (Map.Entry<StoreInfoModel, List<CourierEntry>> entry : within100MStores.entrySet()) {
            System.out.println("Store: " + entry.getKey());
            for (CourierEntry courierEntry : entry.getValue()) {
                System.out.println("    CourierEntry: " + courierEntry);
            }
        }
    }

    private static boolean isWithinRadius(CourierInfoModel courierInfoModel, StoreInfoModel store) {
        double radius = 100;

        boolean result = GeoUtil.isWithinRadius(
                Double.parseDouble(store.getLat()),
                Double.parseDouble(store.getLng()),
                Double.parseDouble(courierInfoModel.getLat()),
                Double.parseDouble(courierInfoModel.getLng()),
                radius);

        if (result)
            System.out.println(courierInfoModel.getCourier() + " is within " + radius + " M radius of " + store.getName());
        else
            System.out.println(courierInfoModel.getCourier() + " is not within " + radius + " M radius of " + store.getName());

        return result;
    }

    // Method to get total travel distance for a given courier
    public Double getTotalTravelDistance(String courier) {
        return courierTrackingUtil.getTotalTravelDistance(courier);
    }

    // Method to process the given courier info
    //Logs the courier and store information and returns the processed courier
    public HashMap<StoreInfoModel, List<CourierEntry>> addCourierInfo(CourierInfoModel courierInfoModel) {

        stores.forEach(store -> {
            if (isWithinRadius(courierInfoModel, store)) {
                Timestamp currentTimeOfTheCourier = courierInfoModel.getTime();

                // Get or create the list of courier entries for the store
                List<CourierEntry> courierEntries = within100MStores
                        .computeIfAbsent(store, k -> new ArrayList<>());

                // Check if the courier has entered this store's radius before
                boolean canAdd = true;
                for (CourierEntry entry : courierEntries) {
                    if (entry.getCourierInfoModel().getCourier().equals(courierInfoModel.getCourier())) {
                        long timeDifference = currentTimeOfTheCourier.getTime() - entry.getLastEntry().getTime();
                        if (timeDifference <= 60000) {
                            // Skip adding this courier as the reentry is within 1 minute
                            canAdd = false;
                            break;
                        }
                    }
                }

                if (canAdd) {
                    // Add the courier entry to the list for this store
                    courierEntries.add(new CourierEntry(courierInfoModel, currentTimeOfTheCourier));
                }

                // Update the courier's travel distance
                String courier = courierInfoModel.getCourier();
                courierTrackingUtil.updateCourierLocation(courier, Double.parseDouble(courierInfoModel.getLat()), Double.parseDouble(courierInfoModel.getLng()));
            }
        });

        logCourierAndStoreDetails(courierInfoModel);

        return within100MStores;
    }
}
