package com.example.baithak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Location_Info {

    @SerializedName("address")
    @Expose
    private String address;

    public Location_Info(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
