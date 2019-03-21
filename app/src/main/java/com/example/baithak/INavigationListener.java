package com.example.baithak;


import android.view.View;



public interface INavigationListener {

    void toFindRestaurant(View view);
    void toSearchPlaces(View view, String category);
    void toShowResults(String[] values, View view);
    void toShowDescription(DataProvider dataProvider,View view);


}
