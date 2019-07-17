package com.hackathon.hackathon.Controller;

import com.hackathon.hackathon.Domain.Location;
import com.hackathon.hackathon.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public void saveLocation(@RequestBody Location location) {
        locationService.location(location);
    }

    @GetMapping("/location")
    public Location getLocation() {
        return locationService.getLocation();
    }
}
