package com.example.baithak;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RestaurantDescription extends Fragment  {
private TextView myResName;
private RatingBar myResRat;
private TextView myResAdd;
private ImageView myResImage;


DataProvider dataProvider;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.description_restaurant,container,false);
      return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myResName=view.findViewById(R.id.myResName);
        myResRat=view.findViewById(R.id.myresRating);
        myResAdd=view.findViewById(R.id.myResAddress);
        myResImage=view.findViewById(R.id.resImage);
        Bundle bundle=getArguments();

        dataProvider= (DataProvider) bundle.getSerializable("sendDescription");
        String resName=dataProvider.getResName();
        String resAddress=dataProvider.getResAddress();
        String resRating=dataProvider.getResRating();
        String resImage=dataProvider.getResImageURL();

        myResName.setText(resName);
        myResAdd.setText(resAddress);
        myResRat.setRating(Float.valueOf(resRating));
        if(resImage.equals("")){

myResImage.setBackgroundResource(R.drawable.noimage);
        }
        else {
        Picasso.with(getActivity()).load(resImage).into(myResImage);}

    }








}
