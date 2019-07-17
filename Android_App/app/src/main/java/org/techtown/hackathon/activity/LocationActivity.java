package org.techtown.hackathon.activity;

import androidx.annotation.RequiresApi;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import org.techtown.hackathon.R;
import org.techtown.hackathon.databinding.ActivityLocationBinding;
import org.techtown.hackathon.viewmodel.LocationViewModel;

public class LocationActivity extends BaseActivity<ActivityLocationBinding> {

    Boolean state = true;
    LocationViewModel locationViewModel;
    double lat, lng;
    String num1, num2;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.txtResult.setText("GPS 가 잡혀야 좌표가 구해짐");

        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // GPS 프로바이더 사용가능여부
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 네트워크 프로바이더 사용가능여부
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        Log.d("Main", "isGPSEnabled=" + isGPSEnabled);
        Log.d("Main", "isNetworkEnabled=" + isNetworkEnabled);

        LocationListener locationListener = new LocationListener() {
            @SuppressLint("SetTextI18n")
            public void onLocationChanged(Location location) {
                if (state) {
                    lat = location.getLatitude();
                    lng = location.getLongitude();

                    binding.txtResult.setText("latitude: " + lat + ", longitude: " + lng);

                    state = false;
                } else {

                }

                String num1 = Double.toString(lat);
                String num2 = Double.toString(lng);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
//                binding.txtResult.setText("onStatusChanged");
            }

            public void onProviderEnabled(String provider) {
                binding.txtResult.setText("onProviderEnabled");
            }

            public void onProviderDisabled(String provider) {
                binding.txtResult.setText("onProviderDisabled");
            }
        };

        // Register the listener with the Location Manager to receive location updates
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("", "");
        } else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }

        // 수동으로 위치 구하기
        String locationProvider = LocationManager.GPS_PROVIDER;
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        if (lastKnownLocation != null) {
            double lng = lastKnownLocation.getLatitude();
            double lat = lastKnownLocation.getLatitude();
            Log.d("Main", "longtitude=" + lng + ", latitude=" + lat);
        }

        binding.button2.setOnClickListener(v -> locationViewModel.postLocation(num1, num2));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_location;
    }
}
