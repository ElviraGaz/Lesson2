package com.example.elvira.lesson2;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bibi1 on 15.08.2017.
 */

class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder> {

    private List<CountryModel> countries;

    public CountriesAdapter(List<CountryModel> countries) {
        this.countries = countries;
    }

    @Override
    public CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.row_country, parent, false);
        return new CountriesViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final CountriesViewHolder holder, int position) {
        // Название страны
        String countryName = countries.get(position).getName();
        TextView countryNameView = holder.countryNameView;
        countryNameView.setText(countryName);

        // Столица
        String capital = countries.get(position).getCapital();
        TextView capitalNameView = holder.capitalNameView;
        capitalNameView.setText(capital);

        //Площадь
        String area = countries.get(position).getArea();
        TextView areaView = holder.areaView;
        areaView.setText(area);

        //Флаг
        Integer flag = countries.get(position).getFlag();
        ImageView flagView = holder.flagView;
        flagView.setBackgroundResource(flag);

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

}