package com.example.baithak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataA {

    @SerializedName("restaurants")
    @Expose
    private ArrayList<Restaurant>restaurants;




    public DataA(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;

    }



    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }


}
