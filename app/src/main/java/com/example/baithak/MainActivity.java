package com.example.baithak;


import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;

import androidx.navigation.Navigation;



public class MainActivity extends AppCompatActivity implements INavigationListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void toFindRestaurant(View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainPage_to_findRestaurant);
    }

    @Override
    public void toSearchPlaces(View view,String category) {
Bundle bundle=new Bundle();
bundle.putString("category",category);
        Navigation.findNavController(view).navigate(R.id.action_findRestaurant_to_searchPlaces,bundle);
    }

    @Override
    public void toShowResults(String[] values, View view) {


        Bundle bundle=new Bundle();
        bundle.putStringArray("dataprovider",values);

        Navigation.findNavController(view).navigate(R.id.action_searchPlaces_to_showResults,bundle);
    }

    @Override
    public void toShowDescription(DataProvider dataProvider, View view) {


Bundle bundle=new Bundle();
bundle.putSerializable("sendDescription",dataProvider);

        Navigation.findNavController(view).navigate(R.id.action_showResults_to_restaurantDescription,bundle);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
