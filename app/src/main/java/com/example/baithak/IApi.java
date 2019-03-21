package com.example.baithak;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IApi {

    String key="//Enter your zomato API";

    @Headers({key})
    @GET("/api/v2.1/locations")
    Call<Data> getData(
     @Query("query") String city,
     @Query("lat") String latitude,
     @Query("lon") String longitude

    );

    @Headers({key})
    @GET("/api/v2.1/search")
    Call<DataA> getSearch(
       @Query("entity_id") String entity_id,
       @Query("entity_type") String entity_type,
       @Query("q") String q,
       @Query("category") String category

    );
}
