package com.example.elvira.lesson2;

/**
 * Created by bibi1 on 14.08.2017.
 */

public class CountryModel {
    String name;
    String capital;
    String area;
    Integer flag;
    Integer likeCount;

    public CountryModel(String name, String capital,String area, Integer flag) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getArea() {
        return area;
    }

    public Integer getFlag(){
        return flag;
    }

    public void like(){
        likeCount++;
    }

    public void dislike(){
        likeCount--;
    }

    public Integer getLikeCount(){
        return likeCount;
    }
}
