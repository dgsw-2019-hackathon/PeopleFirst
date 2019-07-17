package com.hackathon.hackathon.Controller;

import com.hackathon.hackathon.Domain.Medicine;
import com.hackathon.hackathon.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/medicine")
    public void saveMedicine(@RequestBody Medicine medicine) {
        medicineService.medicine(medicine);
    }

    @GetMapping("/medicine/{userId}")
    public Medicine getMedicine(@PathVariable String username) {
        return medicineService.getMedicine(username);
    }
}
