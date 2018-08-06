package com.example.suleman.countries.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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

       final TextView txt = findViewById(R.id.txt);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Countries>> call = apiService.getAllCountries();
        call.enqueue(new Callback<ArrayList<Countries>>() {
            @Override
            public void onResponse(Call<ArrayList<Countries>> call, Response<ArrayList<Countries>> response) {

                if(response.isSuccessful()) {
                        Toast.makeText(HomeActivity.this, "responce is successfull " + response.body().get(1).getName(), Toast.LENGTH_LONG).show();
//                        txt.setText( response.body().string());
                        Log.i("tag", response.body().size() + "");

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(HomeActivity.this, "responce is not successfull", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
