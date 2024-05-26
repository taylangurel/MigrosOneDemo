package com.migrosone.MigrosOneDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierEntry {
    private CourierInfoModel courierInfoModel;
    private Timestamp lastEntry;
}
