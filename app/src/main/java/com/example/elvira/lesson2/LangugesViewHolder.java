package com.example.elvira.lesson2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bibi1 on 16.08.2017.
 */

class LanguagesViewHolder extends RecyclerView.ViewHolder {

    public TextView captionMainView;
    public TextView captionSecondView;
    public TextView likeCounterView;
    public TextView textView;
    public ImageView likeView;
    public ImageView unlikeView;
    public LinearLayout lenearLayout;

    public LanguagesViewHolder(View itemView) {
        super(itemView);
        captionMainView = (TextView) itemView.findViewById(R.id.caption1);
        captionSecondView = (TextView) itemView.findViewById(R.id.captrion2);
        textView = (TextView) itemView.findViewById(R.id.main_text);
        likeCounterView = (TextView) itemView.findViewById(R.id.like_counter);
        likeView = (ImageView) itemView.findViewById(R.id.like);
        unlikeView = (ImageView) itemView.findViewById(R.id.dislike);
        lenearLayout = (LinearLayout)itemView.findViewById(R.id.post);
    }
}