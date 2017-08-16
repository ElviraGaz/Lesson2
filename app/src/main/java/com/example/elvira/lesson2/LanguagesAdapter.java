package com.example.elvira.lesson2;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bibi1 on 16.08.2017.
 */

class LanguagesAdapter extends RecyclerView.Adapter<LanguagesViewHolder> {

    private List<PostModel> languages;

    public LanguagesAdapter(List<PostModel> languages) {
        this.languages = languages;
    }

    @Override
    public LanguagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.row_language, parent, false);

        return new LanguagesViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final LanguagesViewHolder holder, final int position) {
        // Заголовок 1
        String caption1 = languages.get(position).getCaptionMain();
        TextView captionMainView = holder.captionMainView;
        captionMainView.setText(caption1);

        // Заголовок 2
        String caption2 = languages.get(position).getCaptionSecond();
        TextView capitalNameView = holder.captionSecondView;
        capitalNameView.setText(caption2);

        //Текст
        String area = languages.get(position).getText();
        TextView areaView = holder.textView;
        areaView.setText(area);

        holder.likeCounterView.setText(languages.get(position).getLikeCount().toString());

        final LinearLayout layout = holder.lenearLayout;
        if (languages.get(position).getSelected().equals(false))
            layout.setBackgroundColor(Color.WHITE);
        else layout.setBackgroundColor(Color.YELLOW);

        if (languages.get(position).getSelected().equals(false))
            holder.lenearLayout.setBackgroundColor(Color.WHITE);

        else holder.lenearLayout.setBackgroundColor(Color.YELLOW);
        holder.likeCounterView.setText(languages.get(position).getLikeCount().toString());

        View.OnClickListener listenerLike = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer likeCount = languages.get(position).getLikeCount();
                likeCount = likeCount + 1;
                languages.get(position).setLikeCount(likeCount);
                holder.likeCounterView.setText(likeCount.toString());
            }
        };

        View.OnClickListener listenerUnlike = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer likeCount = languages.get(position).getLikeCount();
                likeCount = likeCount - 1;
                languages.get(position).setLikeCount(likeCount);
                holder.likeCounterView.setText(likeCount.toString());
            }
        };

        holder.likeView.setOnClickListener(listenerLike);
        holder.unlikeView.setOnClickListener(listenerUnlike);


        holder.lenearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (languages.get(position).getSelected().equals(false)) {
                    layout.setBackgroundColor(Color.YELLOW);
                    languages.get(position).setSelected(true);

                } else {
                    layout.setBackgroundColor(Color.WHITE);
                    languages.get(position).setSelected(false);
                }

                return false;
            }
        });



    }

    @Override
    public int getItemCount() {
        return languages.size();
    }


}