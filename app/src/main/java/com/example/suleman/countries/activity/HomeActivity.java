package com.example.suleman.countries.activity;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suleman.countries.AdapterObserver;
import com.example.suleman.countries.CountriesFragmentObserver;
import com.example.suleman.countries.CountriesFragmentSubject;
import com.example.suleman.countries.adapter.CountryRecyclerViewAdapter;
import com.example.suleman.countries.fragments.CountriesFragment;
import com.example.suleman.countries.fragments.CountryDetailFragment;
import com.example.suleman.countries.rest.ApiClient;
import com.example.suleman.countries.rest.ApiInterface;
import com.example.suleman.countries.model.Countries;
import com.example.suleman.countries.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements CountriesFragmentSubject{
    private static final String TAG = HomeActivity.class.getSimpleName();
    private CountriesFragment addedFragment;
    private ArrayList<CountriesFragmentObserver> observers;
    ArrayList<Countries> countries;
    boolean responceStatus = false;
    boolean menuCreated = false;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        observers = new ArrayList<CountriesFragmentObserver>();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addedFragment = new CountriesFragment();
        Bundle b = new Bundle();
        b.putBoolean("responceStatus", responceStatus);
        addedFragment.setArguments(b);
        register(addedFragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.outer_layout, addedFragment);
        transaction.addToBackStack(null);
        transaction.commit();


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Countries>> call = apiService.getAllCountries();
        call.enqueue(new Callback<ArrayList<Countries>>() {
            @Override
            public void onResponse(Call<ArrayList<Countries>> call, Response<ArrayList<Countries>> response) {
                if (response.isSuccessful()) {
                    countries = response.body();
                    responceStatus = true;
                    ((CountriesFragment)addedFragment).displayRecyclerview(countries, responceStatus);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(HomeActivity.this, "responce is not successfull", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public ArrayList<Countries> getCountries(){
        return countries;
    }


    private SearchView searchView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                 notifyObservers(query);
                return false;
            }
        });
        menuCreated = true;
        return true;
    }

    public boolean isMenuCreated(){
        return menuCreated;
    }
    @Override
    public void register(CountriesFragmentObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(CountriesFragmentObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String query) {
        for (final CountriesFragmentObserver observer : observers) {
            observer.onSearchTextChanged(query);
        }
    }


    public void moveToDetailFragment(ArrayList<String> ar, ArrayList<Float> f, ArrayList<LatLng> latlngsArrayBorders){
        float[] array = new float[f.size()];

        for (int i = 0; i < f.size(); i++) {
            array[i] = f.get(i);
        }

        Bundle b = new Bundle();
        b.putStringArrayList("borders", ar);
        b.putFloatArray("latlong", array);
        b.putParcelableArrayList("borderslatlng", latlngsArrayBorders);
        CountryDetailFragment detailFragment = new CountryDetailFragment();
        detailFragment.setArguments(b);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.outer_layout, detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showSearchView(){
        toolbar.setVisibility(View.VISIBLE);
    }

    public void hideSearchView(){
        toolbar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else {
            getFragmentManager().popBackStack();
        }
    }
}
