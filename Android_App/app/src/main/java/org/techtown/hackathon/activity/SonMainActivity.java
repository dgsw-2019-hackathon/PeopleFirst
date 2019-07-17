package org.techtown.hackathon.activity;


import android.os.Bundle;

import android.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.techtown.hackathon.R;
import org.techtown.hackathon.databinding.ActivitySonMainBinding;
import org.techtown.hackathon.viewmodel.HeartRateViewModel;
import org.techtown.hackathon.viewmodel.LocationViewModel;

public class SonMainActivity extends BaseActivity<ActivitySonMainBinding> implements OnMapReadyCallback {

    LocationViewModel locationViewModel;
    HeartRateViewModel heartRateViewModel;
    LatLng position;

    GoogleMap map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locationViewModel = new LocationViewModel(this);
        heartRateViewModel = new HeartRateViewModel(this);

        locationViewModel.getLocation();
        heartRateViewModel.getHeartRate();

        locationViewModel.getData().observe(this, location -> {
            double num1 = Double.parseDouble(location.getLatitude());
            double num2 = Double.parseDouble(location.getLongitude());

            position = new LatLng(num1, num2);

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(position);
            markerOptions.title("부모님");
            markerOptions.snippet("계신곳");

            if(map != null) {
                map.addMarker(markerOptions);
                map.moveCamera(CameraUpdateFactory.newLatLng(position));
                map.animateCamera(CameraUpdateFactory.zoomTo(10));
            }
        });

        heartRateViewModel.getData().observe(this, heartRate -> {
            binding.textView.setText(""+heartRate.getHeartRate());
        });

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_son_main;
    }
}
