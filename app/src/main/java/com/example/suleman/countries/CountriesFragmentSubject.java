package com.example.suleman.countries;

public interface CountriesFragmentSubject {
    public void register(CountriesFragmentObserver observer);
    public void unregister(CountriesFragmentObserver observer);
    public void notifyObservers(String query);
}
