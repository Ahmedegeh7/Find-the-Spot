package com.example.baithak;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainPage extends Fragment{
ImageView backImage;
Button getStarted;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.mainpage,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backImage=view.findViewById(R.id.backImage);
        backImage.animate().scaleX(2).scaleY(2).setDuration(4000).start();
        getStarted=view.findViewById(R.id.getStarted);
        getStarted();
    }


    public void getStarted(){
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((INavigationListener)getActivity()).toFindRestaurant(view);
            }
        });

    }
}
