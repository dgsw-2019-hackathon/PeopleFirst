package org.techtown.hackathon.network.interfaces;

import org.techtown.hackathon.network.request.HeartRateRequest;
import org.techtown.hackathon.network.response.HeartRateResponse;
import org.techtown.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HeartRateService {
    @POST("/heartRate")
    Single<Void> postHeartRate(@Body HeartRateRequest request);

    @GET("/heartRate")
    Single<HeartRateResponse> getHeartRate();
}
