package org.techtown.hackathon.network.client;

import org.techtown.hackathon.Utils;
import org.techtown.hackathon.network.interfaces.HeartRateService;
import org.techtown.hackathon.network.request.HeartRateRequest;
import org.techtown.hackathon.network.response.HeartRateResponse;
import org.techtown.hackathon.network.response.LocationResponse;

import io.reactivex.Single;

public class HeartRateClient {
    private HeartRateService service;

    public HeartRateClient() {
        service = Utils.RETROFIT.create(HeartRateService.class);
    }

    public Single<Boolean> postHeartRate(String heartRate) {
        return service.postHeartRate(new HeartRateRequest(heartRate)).map(response -> {
            return true;
        });
    }

    public Single<HeartRateResponse> getLoaction() {
        return service.getHeartRate().map(heartRateResponse -> {
            return heartRateResponse;
        });
    }}
