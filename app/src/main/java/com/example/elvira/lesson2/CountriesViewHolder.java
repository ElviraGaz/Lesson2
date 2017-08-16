package com.example.elvira.lesson2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by bibi1 on 15.08.2017.
 */

class CountriesViewHolder extends ViewHolder {

    public TextView countryNameView;
    public TextView capitalNameView;
    public TextView areaView;
    public ImageView flagView;

    public CountriesViewHolder(View itemView) {
        super(itemView);
        countryNameView = (TextView) itemView.findViewById(R.id.country_name);
        capitalNameView = (TextView) itemView.findViewById(R.id.capital);
        areaView = (TextView) itemView.findViewById(R.id.area);
        flagView = (ImageView) itemView.findViewById(R.id.flag);
    }
}