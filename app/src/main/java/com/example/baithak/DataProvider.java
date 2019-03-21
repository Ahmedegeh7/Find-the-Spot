package com.example.baithak;

import java.io.Serializable;

public class DataProvider implements Serializable {

    String resName;
    String resRating;
    String resImageURL;
    String resAddress;

    public DataProvider(String resName, String resRating,String resImageURL,String resAddress) {
        this.resName = resName;
        this.resRating = resRating;
        this.resAddress=resAddress;
        this.resImageURL=resImageURL;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }
    public String getResName() {
        return resName;
    }

    public String getResImageURL() {
        return resImageURL;
    }

    public void setResImageURL(String resImageURL) {
        this.resImageURL = resImageURL;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public void setResRating(String resRating) {
        this.resRating = resRating;
    }
    public String getResRating() {
        return resRating;
    }
}
