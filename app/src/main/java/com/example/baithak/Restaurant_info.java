package com.example.baithak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Restaurant_info {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("user_rating")
    @Expose
    private User_Rating User_Rating;

    @SerializedName("featured_image")
    @Expose
    private String featured_image;

    @SerializedName("location")
    @Expose
    private Location_Info location;

    public Restaurant_info(String name, com.example.baithak.User_Rating user_Rating,String featured_image,Location_Info location) {
        this.name = name;
        User_Rating = user_Rating;
        this.featured_image=featured_image;
        this.location=location;
    }

    public Location_Info getLocation() {
        return location;
    }

    public void setLocation(Location_Info location) {
        this.location = location;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_Rating(com.example.baithak.User_Rating user_Rating) {
        User_Rating = user_Rating;
    }

    public String getName() {
        return name;
    }

    public com.example.baithak.User_Rating getUser_Rating() {
        return User_Rating;
    }
}
