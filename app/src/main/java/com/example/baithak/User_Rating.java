package com.example.baithak;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class User_Rating {

    @SerializedName("aggregate_rating")
    @Expose
    private String aggregate_rating;



    public User_Rating(String aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }
    public void setAggregate_rating(String aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public String getAggregate_rating() {
        return aggregate_rating;
    }
}
