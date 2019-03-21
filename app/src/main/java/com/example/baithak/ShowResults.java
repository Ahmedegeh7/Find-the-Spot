package com.example.baithak;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ShowResults extends Fragment {
    private IApi iApi;
    String BASE_URL = "https://developers.zomato.com";
    private  String id = "";
    private String name="";
    private String rating="";
    private String imageurl="";
    private String address="";
    Timer timer;
    Runnable runnable;
    Handler handler;
    private String city;
    private String query;
    private String category;
    DataProvider dataProvider;
    ArrayList<DataProvider> listOfName=new ArrayList<>();
    ArrayList<DataProvider> listOfData=new ArrayList<>();

Context context;
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter = null;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show_results,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

progressBar=view.findViewById(R.id.progress);




        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        iApi = retrofit.create(IApi.class);

Bundle bundle=getArguments();
String [] values=bundle.getStringArray("dataprovider");



        myRecyclerView = view.findViewById(R.id.myRecyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);



        adapter=new RecyclerViewAdapter(listOfData, context, new ICustomItemClick() {
            @Override
            public void onCustomClick(DataProvider dataProvider, View view) {

                ((INavigationListener)getActivity()).toShowDescription(dataProvider,view);
                listOfName.clear();
                listOfData.clear();
                adapter.notifyDataSetChanged();




            }
        });

        myRecyclerView.setAdapter(adapter);

        city=values[0];
        query=values[1];
        category=values[2];

        System.out.println(city+query+category);

        getLocationID();

         handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                timer.cancel();
                myRecyclerView.setVisibility(View.VISIBLE);
            }
        };
         timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },1000);

    }




    public void   getLocationID(){


            Call<Data> call = iApi.getData(city, "", "");

            call.enqueue(new Callback<Data>() {
                @Override
                public void onResponse(Call<Data> call, Response<Data> response) {

                    List<Locations> locations = response.body().getLocations();
                    for (Locations locations1:locations) {
                        id = locations1.getId();

                        getRestaurantInfo(id);
                        adapter.notifyDataSetChanged();
                    }






                    System.out.println("id is "+id);

                }

                @Override
                public void onFailure(Call<Data> call, Throwable t) {

                }
            });



    }

    public void getRestaurantInfo(String ids){
        Call<DataA> call=iApi.getSearch(ids,"city",query,category);
        call.enqueue(new Callback<DataA>() {
            @Override
            public void onResponse(Call<DataA> call, Response<DataA> response) {
                ArrayList<Restaurant> restaurants=response.body().getRestaurants();
                for(int i=0; i<restaurants.size(); i++){

                    name=restaurants.get(i).getRestaurant().getName();
                    rating=restaurants.get(i).getRestaurant().getUser_Rating().getAggregate_rating();
                    imageurl=restaurants.get(i).getRestaurant().getFeatured_image();
                    address=restaurants.get(i).getRestaurant().getLocation().getAddress();
                    dataProvider=new DataProvider(name,rating,imageurl,address);
                    listOfName.add(dataProvider);


                }

                for (DataProvider d: listOfName)
                {

                    d.getResRating();
                    d.getResName();
                    listOfData.add(d);
adapter.notifyDataSetChanged();
                }
                System.out.println("the list of data"+listOfName
                );
                System.out.println("the size of data"+listOfData.size());





             //

            }

            @Override
            public void onFailure(Call<DataA> call, Throwable t) {

            }
        });



    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
