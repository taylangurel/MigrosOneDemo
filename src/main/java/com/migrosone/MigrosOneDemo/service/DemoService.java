package com.migrosone.MigrosOneDemo.service;

import com.migrosone.MigrosOneDemo.controller.model.CourierInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DemoService {

    public CourierInfoModel addCourierInfo(CourierInfoModel courierInfoModel) {

        UUID uniqueId = UUID.randomUUID();
        String truncatedId = uniqueId.toString().replace("-", "").substring(0, 10);
        courierInfoModel.setCourier(truncatedId);

        Instant now = Instant.now();
        Timestamp timestamp = Timestamp.from(now);
        courierInfoModel.setTime(timestamp);

        String latitude = "40.992827";
        courierInfoModel.setLat(latitude);
        String longitude = "29.126828";
        courierInfoModel.setLng(longitude);

        System.out.println("Courier: " + courierInfoModel.getCourier());
        System.out.println("Courier Time: " + courierInfoModel.getTime());
        System.out.println("Courier Latitude: " + courierInfoModel.getLat());
        System.out.println("Courier Longitude: " + courierInfoModel.getLng());

        return courierInfoModel;
    }
}
