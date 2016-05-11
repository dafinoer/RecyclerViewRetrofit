package com.example.android.retrofit.callback;

//import android.telecom.Call;

import com.example.android.retrofit.helper.Bunga;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

/**
 * Created by dafidzeko on 5/11/2016.
 */
public interface BungaService {

    @GET("/feeds/flowers.json")
    Call<List<Bunga>> getSemuaBunga();
}
