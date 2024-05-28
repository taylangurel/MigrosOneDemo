package com.migrosone.MigrosOneDemo.controller;

import com.migrosone.MigrosOneDemo.model.CourierEntry;
import com.migrosone.MigrosOneDemo.model.CourierInfoModel;
import com.migrosone.MigrosOneDemo.model.StoreInfoModel;
import com.migrosone.MigrosOneDemo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/addCourierInfo")
    public ResponseEntity<HashMap<StoreInfoModel, List<CourierEntry>>> createUser(@RequestBody CourierInfoModel courierInfoModel) {
        HashMap<StoreInfoModel, List<CourierEntry>> serviceResponse = demoService.addCourierInfo(courierInfoModel);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/getCourierTotalDistance")
    public String getCourierTotalDistance(@RequestParam(name = "courier", defaultValue = "") String courier) {
        return "Total Distance traveled by " + courier + " is " + demoService.getTotalTravelDistance(courier) + " meters.";
    }
}
