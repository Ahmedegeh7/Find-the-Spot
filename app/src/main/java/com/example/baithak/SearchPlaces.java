package com.example.baithak;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



import android.widget.Toast;


import com.rengwuxian.materialedittext.MaterialEditText;






public class SearchPlaces extends Fragment {
    MaterialEditText citys,Query;
    Button find;



    String query;
    String categorie;
    String city;

    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_restaurant, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        citys = view.findViewById(R.id.citys);
        find = view.findViewById(R.id.find);

        Query=view.findViewById(R.id.queries);

Bundle bundle=getArguments();
categorie=bundle.getString("category");
System.out.println("The category is "+categorie);




        getData();





    }

    public void getData() {
find.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getValue(view);
        citys.setText("");
        Query.setText("");
    }
});

        }


     public void  getValue(View view){

    city=citys.getText().toString();
    query= Query.getText().toString();

    if(city.equals("") && query.equals("")){
        Toast.makeText(getActivity(), "Please enter the value", Toast.LENGTH_SHORT).show();
    }

    else{
        String[] values={city,query,categorie};

        ((INavigationListener)getActivity()).toShowResults(values,view);


    }


        }


}


















