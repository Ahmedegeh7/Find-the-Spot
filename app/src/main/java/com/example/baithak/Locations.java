package com.example.baithak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Locations {

@SerializedName("entity_id")
@Expose
    private String entity_id;


    public Locations(String id) {
        this.entity_id = id;
    }

    public String getId() {
        return entity_id;
    }
}
