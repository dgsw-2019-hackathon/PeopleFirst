package org.techtown.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.techtown.hackathon.R;
import org.techtown.hackathon.databinding.ActivityLoginBinding;
import org.techtown.hackathon.network.client.LoginClient;
import org.techtown.hackathon.viewmodel.LocationViewModel;
import org.techtown.hackathon.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    LoginViewModel loginViewModel;
    LocationViewModel locationViewModel;
    LatLng position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new LoginViewModel(this);

        locationViewModel = new LocationViewModel(this);

        locationViewModel.getLocation();

        locationViewModel.getData().observe(this, location -> {
            double num1 = Double.parseDouble(location.getLatitude());
            double num2 = Double.parseDouble(location.getLongitude());

            position = new LatLng(num1, num2);
        });

        binding.loginBtn.setOnClickListener(view -> {
            login();

            if (binding.idEditText.getText().toString().equals("member")) {
                Intent intent = new Intent(getApplicationContext(), SonMainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void login() {
        loginViewModel.postLogin(binding.idEditText.getText().toString(), binding.passwordEditText.getText().toString());
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }
}
