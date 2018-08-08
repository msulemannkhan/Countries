package com.example.suleman.countries.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.suleman.countries.AdapterObserver;
import com.example.suleman.countries.CountriesFragmentObserver;
import com.example.suleman.countries.CountriesFragmentSubject;
import com.example.suleman.countries.R;
import com.example.suleman.countries.activity.HomeActivity;
import com.example.suleman.countries.adapter.CountryRecyclerViewAdapter;
import com.example.suleman.countries.model.Countries;
import com.example.suleman.countries.rest.ApiClient;
import com.example.suleman.countries.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CountriesFragment extends Fragment implements CountriesFragmentObserver , AdapterObserver {
    private CountryRecyclerViewAdapter mAdapter;

    // Required empty public constructor
    public CountriesFragment() {

    }

    public static CountriesFragment newInstance() {
        CountriesFragment fragment = new CountriesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_countries, container, false);

        final RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.country_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Countries>> call = apiService.getAllCountries();
        call.enqueue(new Callback<ArrayList<Countries>>() {
            @Override
            public void onResponse(Call<ArrayList<Countries>> call, Response<ArrayList<Countries>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Countries> countries = response.body();
                    mAdapter = new CountryRecyclerViewAdapter(countries, R.layout.countries_rv_item, getActivity());
                    mAdapter.register(CountriesFragment.this);
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getActivity(), "responce is not successfull", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void onSearchTextChanged(String query) {
        Toast.makeText(getContext(), "I am being observed", Toast.LENGTH_SHORT).show();
        mAdapter.getFilter().filter(query);
    }

    @Override
    public void moveRecyclerviewToDetailFragment(ArrayList<String> ar) {
        ((HomeActivity)getActivity()).moveToDetailFragment(ar);
    }
}
