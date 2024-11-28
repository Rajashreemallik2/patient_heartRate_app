package com.example.medApp.controller;

import com.example.medApp.models.HeartRate;
import com.example.medApp.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heartrates")
public class HeartRateController {

    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/{patientId}")
    public HeartRate recordHeartRate(@PathVariable Long patientId, @RequestBody HeartRate heartRate) {
        return heartRateService.recordHeartRate(patientId, heartRate);
    }

    @GetMapping("/{patientId}")
    public List<HeartRate> getHeartRates(@PathVariable Long patientId) {
        return heartRateService.getHeartRates(patientId);
    }


}
