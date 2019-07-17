package com.hackathon.hackathon.Service;

import com.hackathon.hackathon.Domain.Location;
import com.hackathon.hackathon.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceInpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void location(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location getLocation() {
        List<Location> data = locationRepository.findTop1ByOrderByIdDesc();
        if(data.size() > 0) return data.get(0);
        else return null;
    }

}
