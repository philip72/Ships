package com.example.ships;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/ships")
    Call<List<ShipModal>>getShips();
}
