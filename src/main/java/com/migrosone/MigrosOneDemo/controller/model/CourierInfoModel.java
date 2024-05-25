package com.migrosone.MigrosOneDemo.controller.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CourierInfoModel {
    private Timestamp time;
    private String courier;
    private String lat;
    private String lng;
}
