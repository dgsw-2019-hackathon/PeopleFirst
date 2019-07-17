package com.hackathon.hackathon.Controller;

import com.hackathon.hackathon.Domain.HeartRate;
import com.hackathon.hackathon.Service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeartRateController {

    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/heartRate")
    public void saveHeartRate(@RequestBody HeartRate heartRate) {
        heartRateService.heartRate(heartRate);
    }

    @GetMapping("/heartRate")
    public HeartRate getHeartRate() {
        return heartRateService.getHeartRate();
    }
}
