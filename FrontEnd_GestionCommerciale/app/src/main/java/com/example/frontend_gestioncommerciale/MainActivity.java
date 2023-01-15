package com.example.frontend_gestioncommerciale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frontend_gestioncommerciale.models.Utilisateur;
import com.example.frontend_gestioncommerciale.models.retrofit.ApiInterface;
import com.example.frontend_gestioncommerciale.models.retrofit.RetrofitService;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    TextView tvRegister;
    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        tvRegister = findViewById(R.id.goToRegister);

        RetrofitService retrofitService = new RetrofitService();
        ApiInterface apiInterface = retrofitService.getRetrofit().create(ApiInterface.class);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUsername() && validatePassword()) {
                    Utilisateur user = new Utilisateur();
                    user.setUsername(etUsername.getText().toString());
                    user.setPassword(etPassword.getText().toString());

                    apiInterface.login(user).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.body() != null) {
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });


    }

    private boolean validateUsername() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError("username cannot be empty");
            etUsername.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("password cannot be empty");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

}