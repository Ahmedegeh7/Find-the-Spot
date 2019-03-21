package com.example.baithak;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FindRestaurant extends Fragment implements View.OnClickListener {
String categorie;
Button breakfast,lunch,dinner,pub,delivery;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.find_restaurant,container,false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        breakfast=view.findViewById(R.id.breakfast);
        lunch=view.findViewById(R.id.lunch);
        dinner=view.findViewById(R.id.dinner);
        pub=view.findViewById(R.id.pub);
        delivery=view.findViewById(R.id.delivery);

breakfast.setOnClickListener(this);
lunch.setOnClickListener(this);
dinner.setOnClickListener(this);
pub.setOnClickListener(this);
delivery.setOnClickListener(this);
    }


   public void onClick(View view){
    switch (view.getId())
    {
        case R.id.breakfast:

           System.out.println("tag :"+view.getTag().toString());
            ((INavigationListener)getActivity()).toSearchPlaces(view,view.getTag().toString());
            break;
        case R.id.lunch:

            System.out.println("tag :"+view.getTag().toString());
            ((INavigationListener)getActivity()).toSearchPlaces(view,view.getTag().toString());
        break;
        case R.id.dinner:
            System.out.println("tag :"+view.getTag().toString());
            ((INavigationListener)getActivity()).toSearchPlaces(view,view.getTag().toString());

            break;
        case R.id.pub:
            System.out.println("tag :"+view.getTag().toString());
            ((INavigationListener)getActivity()).toSearchPlaces(view,view.getTag().toString());

            break;
        case R.id.delivery:
            System.out.println("tag :"+view.getTag().toString());
            ((INavigationListener)getActivity()).toSearchPlaces(view,view.getTag().toString());
            break;
    }


   }

       // ((INavigationListener)getActivity()).toSearchPlaces(view);

    /*    else if (view.getTag().equals("9")){

            categorie="9";
            ((INavigationListener)getActivity()).toSearchPlaces(view,categorie);

        }
        else if (view.getTag().equals("10")){

            categorie="10";
            ((INavigationListener)getActivity()).toSearchPlaces(view,categorie);
        }
        else if (view.getTag().equals("11")){

            categorie="11";
            ((INavigationListener)getActivity()).toSearchPlaces(view,categorie);
        } else if (view.getTag().equals("1")){

            categorie="1";
            ((INavigationListener)getActivity()).toSearchPlaces(view,categorie);
        }
*/




}
