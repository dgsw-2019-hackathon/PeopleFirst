package com.hackathon.hackathon.Service;

import com.hackathon.hackathon.Domain.HeartRate;
import com.hackathon.hackathon.Repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartRateServiceInpl implements HeartRateService {

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Override
    public void heartRate(HeartRate heartRate) {
        heartRateRepository.save(heartRate);
    }
//
//    @Override
//    public HeartRate getHeartRate(String username) {
//        return heartRateRepository.findTop1ByUsernameOrderByCreated(username).get(0);
//    }
}
