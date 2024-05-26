package com.migrosone.MigrosOneDemo.controller;

import com.migrosone.MigrosOneDemo.model.CourierInfoModel;
import com.migrosone.MigrosOneDemo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/addCourierInfo")
    public ResponseEntity<CourierInfoModel> createUser(@RequestBody CourierInfoModel courierInfoModel) {
        CourierInfoModel serviceResponse = demoService.addCourierInfo(courierInfoModel);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/getCourierTotalDistance")
    public String getCourierTotalDistance(@RequestParam(name = "courier", defaultValue = "") String courier) {
        return "Total Distance traveled by " + courier + " is " + demoService.getTotalTravelDistance(courier) + " meters.";
    }
}
