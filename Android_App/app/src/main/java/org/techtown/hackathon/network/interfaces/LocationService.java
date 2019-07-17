package org.techtown.hackathon.network.interfaces;

import org.techtown.hackathon.network.request.LocationRequest;
import org.techtown.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LocationService {

    @POST("/location")
    Single<Response> postLocation(
            @Body LocationRequest request
    );
}
