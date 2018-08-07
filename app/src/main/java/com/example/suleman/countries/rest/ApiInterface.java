package com.example.suleman.countries.rest;

import com.caverock.androidsvg.SVG;
import com.example.suleman.countries.model.Countries;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Url;

public abstract interface ApiInterface {

    @GET("rest/v2/all/")
    public abstract Call<ArrayList<Countries>> getAllCountries();
}
