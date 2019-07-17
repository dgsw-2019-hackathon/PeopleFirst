package com.hackathon.hackathon.Service;

import com.hackathon.hackathon.Domain.Location;
import com.hackathon.hackathon.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceInpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void location(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location getLocation(String username) {
//        return locationRepository.findTop1ByUsernameOrderByCreated(username).get(0);
        return null;
    }

}
