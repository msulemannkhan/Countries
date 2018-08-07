package com.example.suleman.countries.adapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.bumptech.glide.RequestBuilder;
import com.example.suleman.countries.R;
import com.example.suleman.countries.SvgSoftwareLayerSetter;
import com.example.suleman.countries.model.Countries;
import java.util.ArrayList;
import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder> {
    private ArrayList<Countries> countriesArrayList;
    private int rowLayout;
    private Context context;
    private RequestBuilder<PictureDrawable> requestBuilder;


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
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CountryRecyclerViewAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return countriesArrayList.size();
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, final int position) {
        holder.countryName.setText(countriesArrayList.get(position).getName());
        holder.countryRegion.setText(countriesArrayList.get(position).getRegion());

        requestBuilder = Glide.with(context)
                .as(PictureDrawable.class)
                .listener(new SvgSoftwareLayerSetter());
        if(countriesArrayList.size() >0){
            requestBuilder.load(Uri.parse(countriesArrayList.get(position).getFlag())).into(holder.countryFlag);
            Log.i("tag", ""+countriesArrayList.get(position).getFlag());
        }else
            Log.i("tag", "size less then 0");


//        SvgLoader.pluck()
//                .with((Activity) context)
//                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//                .load(countriesArrayList.get(position).getFlag(), holder.countryFlag);
    }
}
