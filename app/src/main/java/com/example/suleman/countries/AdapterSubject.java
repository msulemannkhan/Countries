package com.example.suleman.countries;

import java.util.ArrayList;

public interface AdapterSubject {
    public void register(AdapterObserver observer);
    public void unregister(AdapterObserver observer);
    public void notifyObservers(ArrayList<String> ar);
}
