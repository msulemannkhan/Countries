package com.example.suleman.countries;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public interface AdapterSubject {
    public void register(AdapterObserver observer);
    public void unregister(AdapterObserver observer);
    public void notifyObservers(ArrayList<String> ar, ArrayList<Float> f, ArrayList<LatLng> a);
}
