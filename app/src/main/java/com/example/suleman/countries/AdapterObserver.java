package com.example.suleman.countries;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public interface AdapterObserver {
    public void moveRecyclerviewToDetailFragment(ArrayList<String> ar, ArrayList<Float> f, ArrayList<LatLng> d);
}
