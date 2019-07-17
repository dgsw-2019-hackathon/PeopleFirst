package org.techtown.hackathon.network.interfaces;

import org.techtown.hackathon.network.request.LocationRequest;
import org.techtown.hackathon.network.response.LocationResponse;
import org.techtown.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LocationService {

    @POST("/location")
    Single<Void> postLocation(
            @Body LocationRequest request
    );

    @GET("/location")
    Single<LocationResponse> getLocation();
}
