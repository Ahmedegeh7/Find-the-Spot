package com.example.baithak;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
private ArrayList<DataProvider> data;
 private ICustomItemClick iCustomItemClick;

private Context context;

    public RecyclerViewAdapter(ArrayList<DataProvider> data, Context context,ICustomItemClick iCustomItemClick) {
        this.data = data;
        this.context = context;
        this.iCustomItemClick=iCustomItemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler, viewGroup, false);
        final MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iCustomItemClick.onCustomClick(data.get(holder.getAdapterPosition()),view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
holder.resName.setText(data.get(i).resName);
//holder.resRat.setText(data.get(i).resRating);
holder.ratingBar.setRating(Float.valueOf(data.get(i).resRating));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView resName;

        RatingBar ratingBar;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resName=itemView.findViewById(R.id.resName);

            ratingBar=itemView.findViewById(R.id.resStar);
        }
    }
}
