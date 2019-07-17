package org.techtown.hackathon.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import org.techtown.hackathon.Model.login.Login;
import org.techtown.hackathon.network.client.LoginClient;
import org.techtown.hackathon.network.request.LoginRequest;

public class LoginViewModel extends BaseViewModel<Login>{
    private LoginClient loginClient;

    private final MutableLiveData<String> isSuccess = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public LoginViewModel(Context context) {
        super(context);
        loginClient = new LoginClient();
    }

    @SuppressLint("CheckResult")
    public void postLogin(String username, String password) {
        loading.setValue(true);

        addDisposable(loginClient.postLogin(username, password), getBaseObserver());
    }
}
