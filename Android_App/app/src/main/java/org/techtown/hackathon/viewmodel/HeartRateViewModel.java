package org.techtown.hackathon.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import org.techtown.hackathon.network.client.HeartRateClient;

public class HeartRateViewModel extends BaseViewModel{
    private HeartRateClient heartRateClient;

    private final MutableLiveData<String> isSuccess = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public HeartRateViewModel(Context context) {
        super(context);
        heartRateClient = new HeartRateClient();
    }

    @SuppressLint("CheckResult")
    public void postHeartRate(String heartRate) {
        loading.setValue(true);

        addDisposable(heartRateClient.postHeartRate(heartRate), getBaseObserver());
    }
}
