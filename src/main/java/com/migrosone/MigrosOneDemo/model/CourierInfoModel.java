package com.migrosone.MigrosOneDemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CourierInfoModel {
    private Timestamp time;
    private String courier;
    private String lat;
    private String lng;

    //private String courierId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
}
