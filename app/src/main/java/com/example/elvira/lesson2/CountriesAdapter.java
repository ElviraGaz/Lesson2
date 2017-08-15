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
        String cityName = countries.get(position).getName();
        TextView cityNameView = holder.capitalNameView;
        cityNameView.setText(cityName);

        // Столица
        String countryName = countries.get(position).getCapital();
        TextView countryNameView = holder.countryNameView;
        countryNameView.setText(countryName);

        //Площадь
        String area = countries.get(position).getArea();
        TextView areaView = holder.areaView;
        areaView.setText(area);

        //Флаг
        Integer flag = countries.get(position).getFlag();
        ImageView flagView = holder.flagView;
        flagView.setBackgroundResource(flag);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer result = Integer.parseInt(holder.likeCounterView.getText().toString()) + 1;
                holder.likeCounterView.setText(result.toString());
            }
        };
        holder.likeCounterView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public void add(int i, List<CountryModel> newlist) {
        countries.addAll(i, newlist);
        notifyItemRangeInserted(i, newlist.size());
    }
}