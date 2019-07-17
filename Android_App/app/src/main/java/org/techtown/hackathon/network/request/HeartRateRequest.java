package org.techtown.hackathon.network.request;

public class HeartRateRequest {
    private String heartRate;

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public HeartRateRequest(String heartRate) {
        this.heartRate = heartRate;
    }
}
