package com.example.ships;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    private  static final String BASE_URL= "https://api.spacexdata.com/v3/ships";
    private static Retrofit retrofit= null;

    public static ApiInterface requestManager(){
        if(retrofit== null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiInterface.class);
    }
}
