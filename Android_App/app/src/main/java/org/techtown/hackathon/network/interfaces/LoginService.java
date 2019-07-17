package org.techtown.hackathon.network.interfaces;

import org.techtown.hackathon.network.request.LoginRequest;
import org.techtown.hackathon.network.response.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/login")
    Single<LoginResponse> postLogin(
            @Body LoginRequest request
    );
}
