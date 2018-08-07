package com.example.suleman.countries.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suleman.countries.adapter.CountryRecyclerViewAdapter;
import com.example.suleman.countries.rest.ApiClient;
import com.example.suleman.countries.rest.ApiInterface;
import com.example.suleman.countries.model.Countries;
import com.example.suleman.countries.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.country_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Countries>> call = apiService.getAllCountries();
        call.enqueue(new Callback<ArrayList<Countries>>() {
            @Override
            public void onResponse(Call<ArrayList<Countries>> call, Response<ArrayList<Countries>> response) {

                if(response.isSuccessful()) {
                    ArrayList<Countries> movies = response.body();
                    recyclerView.setAdapter(new CountryRecyclerViewAdapter(movies, R.layout.countries_rv_item, HomeActivity.this));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(HomeActivity.this, "responce is not successfull", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
