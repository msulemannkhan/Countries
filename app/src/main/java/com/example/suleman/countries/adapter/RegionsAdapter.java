package com.example.suleman.countries.adapter;

import android.content.Context;
import android.graphics.Region;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.suleman.countries.R;
import com.example.suleman.countries.model.Countries;

import java.util.ArrayList;

public class RegionsAdapter  extends RecyclerView.Adapter<RegionsAdapter.RegionViewHolder> {
    private ArrayList<String> regionsArrayList;
    private int rowLayout;
    private Context context;

    public static class RegionViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout countryLayout;
        TextView regionName;


        public RegionViewHolder(View v) {
            super(v);
            countryLayout = (ConstraintLayout) v.findViewById(R.id.regions_layout);
            regionName = (TextView) v.findViewById(R.id.region_name_rv_item);
        }
    }


    public RegionsAdapter(ArrayList<String> regions, int rowLayout, Context context) {
        this.regionsArrayList = regions;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RegionsAdapter.RegionViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RegionsAdapter.RegionViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return regionsArrayList.size();
    }

    @Override
    public void onBindViewHolder(RegionsAdapter.RegionViewHolder holder, final int position) {
        holder.regionName.setText(regionsArrayList.get(position));
    }

}
