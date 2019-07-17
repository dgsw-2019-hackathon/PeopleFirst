package org.techtown.hackathon.network.client;

import android.util.Log;

import org.techtown.hackathon.Utils;
import org.techtown.hackathon.network.interfaces.LoginService;
import org.techtown.hackathon.network.request.LoginRequest;

import io.reactivex.Single;

public class LoginClient extends NetworkClient {
    private LoginService login;

    public LoginClient() { login = Utils.RETROFIT.create(LoginService.class); }

    public Single<String> postLogin(String username, String password) {
        return login.postLogin(new LoginRequest(username, password)).map(loginResponse ->{
            Log.e("aa",loginResponse.getUsername());
            return loginResponse.getUsername();
        });
    }
}