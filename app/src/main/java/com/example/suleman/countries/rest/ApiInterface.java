package com.example.suleman.countries.rest;

import com.example.suleman.countries.model.Countries;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.Call;

public abstract interface ApiInterface {

    @GET("all/")
    public abstract Call<ArrayList<Countries>> getAllCountries();
}
