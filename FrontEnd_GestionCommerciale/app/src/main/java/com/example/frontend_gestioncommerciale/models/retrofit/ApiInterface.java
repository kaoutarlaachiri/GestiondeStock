package com.example.frontend_gestioncommerciale.models.retrofit;

import com.example.frontend_gestioncommerciale.models.Utilisateur;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.GET;


public interface ApiInterface {


    @POST("/users")
    Call<ResponseBody> addUser(@Body Utilisateur user);

    @GET("/users")
    Call<ResponseBody> getUser(@Body Utilisateur user);

    @POST("/users/login")
    Call<ResponseBody> login(@Body Utilisateur user);
}
