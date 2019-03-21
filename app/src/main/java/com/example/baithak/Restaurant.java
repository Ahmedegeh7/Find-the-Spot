package com.example.baithak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Restaurant {


    @SerializedName("restaurant")
    @Expose
    private Restaurant_info restaurant;



    public Restaurant(Restaurant_info restaurant) {
        this.restaurant = restaurant;

    }



    public Restaurant_info getRestaurant() {
        return restaurant;
    }
}
