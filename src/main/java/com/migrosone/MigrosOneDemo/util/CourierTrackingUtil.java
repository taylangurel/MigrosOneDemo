package com.migrosone.MigrosOneDemo.util;

import com.migrosone.MigrosOneDemo.model.CourierTravelInfo;

import java.util.HashMap;
import java.util.Map;

public class CourierTrackingUtil {
    private Map<String, CourierTravelInfo> courierTravelMap = new HashMap<>();

    public void updateCourierLocation(String courierId, double latitude, double longitude) {
        CourierTravelInfo travelInfo = courierTravelMap.computeIfAbsent(courierId, k -> new CourierTravelInfo());
        travelInfo.updateLocation(latitude, longitude);
    }

    public double getTotalTravelDistance(String courier) {
        CourierTravelInfo travelInfo = courierTravelMap.get(courier);
        return travelInfo != null ? travelInfo.getTotalDistance() : 0.0;
    }
}
