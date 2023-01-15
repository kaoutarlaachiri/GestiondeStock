package com.example.frontend_gestioncommerciale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.frontend_gestioncommerciale.models.Utilisateur;
import com.example.frontend_gestioncommerciale.models.retrofit.ApiInterface;
import com.example.frontend_gestioncommerciale.models.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etRegisterUsername, etRegisterPassword, etRegisterEmail;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterUsername = findViewById(R.id.r_username);
        etRegisterEmail = findViewById(R.id.r_email);
        etRegisterPassword = findViewById(R.id.r_password);
        btnRegister = findViewById(R.id.register);

        RetrofitService retrofitService = new RetrofitService();
        ApiInterface apiInterface = retrofitService.getRetrofit().create(ApiInterface.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUserName() && validatePassword()) {
                    Utilisateur user = new Utilisateur(etRegisterUsername.getText().toString(),etRegisterEmail.getText().toString(), etRegisterPassword.getText().toString());
                    apiInterface.addUser(user).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.body() != null) {
                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "something went wrong! please try again", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);


                        }
                    });
                }

            }
        });


    }

    private boolean validatePassword() {
        if (etRegisterPassword.getText().toString().length() < 6) {
            etRegisterPassword.setError("password must be at least 6 characters");
            etRegisterPassword.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etRegisterPassword.getText().toString())) {
            etRegisterPassword.setError("password is empty");
            etRegisterPassword.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateUserName() {
        if (TextUtils.isEmpty(etRegisterUsername.getText().toString())) {
            etRegisterUsername.setError("username is empty");
            etRegisterUsername.requestFocus();
            return false;
        }
        return true;
    }
}
