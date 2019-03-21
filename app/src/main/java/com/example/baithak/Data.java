package com.example.baithak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class Data {

    @SerializedName("location_suggestions")
    @Expose
    private ArrayList<Locations> locations;

    public Data(ArrayList<Locations> locations) {
        this.locations = locations;
    }

    public ArrayList<Locations> getLocations() {
        return locations;
    }
}
