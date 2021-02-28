package com.example.nda;

import  java.util.List;
import  retrofit2.Call;
import  retrofit2.http.GET;


public interface VerDatos {
    @GET("/users")
    Call<List<RetroUser>> getAllUsers();
}
