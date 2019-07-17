package org.techtown.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.techtown.hackathon.R;
import org.techtown.hackathon.databinding.ActivityLoginBinding;
import org.techtown.hackathon.network.client.LoginClient;
import org.techtown.hackathon.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new LoginViewModel(this);

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
