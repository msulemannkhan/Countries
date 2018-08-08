package com.example.suleman.countries.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.suleman.countries.R;

import java.util.ArrayList;

public class CountryDetailFragment extends Fragment {

    public CountryDetailFragment() {
    }

    public static CountryDetailFragment newInstance(String param1, String param2) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            ArrayList<String> a = getArguments().getStringArrayList("borders");

            Toast.makeText(getActivity(), "" + a.size(), Toast.LENGTH_SHORT).show();
               return inflater.inflate(R.layout.fragment_country_detail, container, false);
    }
}
