package com.example.android.retrofit.controller;

import com.example.android.retrofit.callback.BungaService;
import com.example.android.retrofit.helper.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dafidzeko on 5/11/2016.
 */
public class RestManager {

    private BungaService bungaService ;

    public BungaService ambilBungaService(){
        if(bungaService==null){

            Retrofit retrofit =new Retrofit.Builder()
                    .baseUrl(Constant.HTTP.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            bungaService = retrofit.create(BungaService.class);

        }
        return bungaService;
    }
}
