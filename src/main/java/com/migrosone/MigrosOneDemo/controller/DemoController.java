package com.migrosone.MigrosOneDemo.controller;

import com.migrosone.MigrosOneDemo.controller.model.CourierInfoModel;
import com.migrosone.MigrosOneDemo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/addCourierInfo")
    public ResponseEntity<CourierInfoModel> createUser(@RequestBody CourierInfoModel courierInfoModel) {
        CourierInfoModel serviceResponse = demoService.addCourierInfo(courierInfoModel);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
