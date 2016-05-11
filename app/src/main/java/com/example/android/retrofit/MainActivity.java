package com.example.android.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.retrofit.adapter.BungaAdapter;
import com.example.android.retrofit.callback.BungaService;
import com.example.android.retrofit.controller.RestManager;
import com.example.android.retrofit.helper.Bunga;
import com.example.android.retrofit.helper.Constant;
import com.example.android.retrofit.ui.DetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BungaAdapter.BungaKlik {

    private RecyclerView recyclerView;
    private RestManager restManager;
    private BungaAdapter bungaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        restManager = new RestManager();
        Call<List<Bunga>> listCall = restManager.ambilBungaService().getSemuaBunga();
        listCall.enqueue(new Callback<List<Bunga>>() {
            @Override
            public void onResponse(Call<List<Bunga>> call, Response<List<Bunga>> response) {

                if (response.isSuccessful()) {
                    List<Bunga> bungaList = response.body();
                    for (int i = 0 ; i < bungaList.size() ;i++){
                        Bunga  bunga  = bungaList.get(i);
                        bungaAdapter.addBunga(bunga);
                    }

                }else {
                    int sc = response.code();
                    switch (sc){

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Bunga>> call, Throwable t) {

            }
        });

    }

    private void configView() {
        recyclerView = (RecyclerView)findViewById(R.id.reycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        bungaAdapter = new BungaAdapter(this);
        recyclerView.setAdapter(bungaAdapter);
    }

    @Override
    public void onClick(int position) {
        Bunga pilihBunga = bungaAdapter.getAmbilBunga(position);
        Intent  intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constant.REFERENCE.FLOWER, pilihBunga);
        startActivity(intent);
    }
}
