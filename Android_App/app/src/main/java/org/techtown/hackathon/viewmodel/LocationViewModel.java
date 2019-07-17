package org.techtown.hackathon.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;

import androidx.lifecycle.MutableLiveData;

import org.techtown.hackathon.network.client.LocationClient;
import org.techtown.hackathon.network.response.LocationResponse;

public class LocationViewModel extends BaseViewModel<LocationResponse> {
    private LocationClient locationClient;

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public LocationViewModel(Context context) {
        super(context);
        locationClient = new LocationClient();
    }

    @SuppressLint("CheckResult")
    public void postLocation(String latitude, String longitude) {
        loading.setValue(true);

        addDisposable(locationClient.postLocation(latitude, longitude), getBaseObserver());
    }

    @SuppressLint("CheckResult")
    public void getLocation() {
        loading.setValue(true);

        addDisposable(locationClient.getLoaction(), getDataObserver());
    }
}
