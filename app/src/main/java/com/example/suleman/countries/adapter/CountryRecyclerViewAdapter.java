package com.example.suleman.countries.adapter;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.RequestBuilder;
import com.example.suleman.countries.AdapterObserver;
import com.example.suleman.countries.AdapterSubject;
import com.example.suleman.countries.R;
import com.example.suleman.countries.glide.SvgSoftwareLayerSetter;
import com.example.suleman.countries.model.Countries;
import java.util.ArrayList;
import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder> implements Filterable, AdapterSubject {
    private ArrayList<Countries> countriesArrayList;
    private ArrayList<Countries> countriesArrayListFiltered;
    private ArrayList<AdapterObserver> adapterObservers;


    private int rowLayout;
    private Context context;
    private RequestBuilder<PictureDrawable> requestBuilder;

    @Override
    public void register(AdapterObserver observer) {
        if (!adapterObservers.contains(observer)) {
            adapterObservers.add(observer);
        }
    }

    @Override
    public void unregister(AdapterObserver observer) {
        adapterObservers.remove(observer);
    }

    @Override
    public void notifyObservers(ArrayList<String> ar) {
        for (final AdapterObserver observer : adapterObservers) {
            observer.moveRecyclerviewToDetailFragment(ar);
        }
    }


    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout countryLayout;
        TextView countryName;
        TextView countryRegion;
        ImageView countryFlag;
        ImageView layoutRightArrow;


        public CountryViewHolder(View v) {
            super(v);
            countryLayout = (ConstraintLayout) v.findViewById(R.id.countries_layout);
            countryName = (TextView) v.findViewById(R.id.country_name_rv_item);
            countryRegion = (TextView) v.findViewById(R.id.country_region_rv_item);
            countryFlag = (ImageView) v.findViewById(R.id.country_flag_rv_item);
            layoutRightArrow = (ImageView) v.findViewById(R.id.right_arrow_detail_rv_item);
        }
    }

    public CountryRecyclerViewAdapter(ArrayList<Countries> countries, int rowLayout, Context context) {
        this.countriesArrayList = countries;
        this.countriesArrayListFiltered = countries;
        this.rowLayout = rowLayout;
        this.context = context;
        adapterObservers = new ArrayList<AdapterObserver>();
    }

    @Override
    public CountryRecyclerViewAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return countriesArrayListFiltered.size();
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, final int position) {
        holder.countryName.setText(countriesArrayListFiltered.get(position).getName());
        holder.countryRegion.setText(countriesArrayListFiltered.get(position).getRegion());

        requestBuilder = Glide.with(context)
                .as(PictureDrawable.class)
                .listener(new SvgSoftwareLayerSetter());
        requestBuilder.load(Uri.parse(countriesArrayListFiltered.get(position).getFlag())).into(holder.countryFlag);

        holder.layoutRightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> ar = (ArrayList<String>) countriesArrayListFiltered.get(position).getBorders();
                notifyObservers(ar);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                   countriesArrayListFiltered = countriesArrayList;
                } else {
                    ArrayList<Countries> filteredList = new ArrayList<>();
                    for (Countries row : countriesArrayList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getRegion().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    countriesArrayListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = countriesArrayListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                countriesArrayListFiltered = (ArrayList<Countries>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
