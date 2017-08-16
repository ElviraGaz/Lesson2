package com.example.elvira.lesson2;

import org.w3c.dom.Text;

/**
 * Created by bibi1 on 16.08.2017.
 */

public class PostModel {
    String captionMain;
    String captionSecond ;
    String text;
    Integer likeCount;
    Boolean selected;

    public PostModel(String captionMain, String captionSecond, String text){
        this.captionMain = captionMain;
        this.captionSecond = captionSecond;
        this.text = text;
        this.selected = false;
        this.likeCount = 0;
    }

    public String getCaptionMain(){
        return captionMain;
    }

    public String getCaptionSecond(){
        return captionSecond;
    }

    public String getText(){
        return text;
    }

    public Integer getLikeCount(){
        return likeCount;
    }

    public Boolean getSelected(){
        return selected;
    }

    public void setSelected(boolean flag){
        this.selected = flag;
    }

    public void setLikeCount(Integer count){
        this.likeCount = count;
    }
}
