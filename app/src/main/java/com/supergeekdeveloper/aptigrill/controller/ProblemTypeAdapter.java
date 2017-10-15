package com.supergeekdeveloper.aptigrill.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.supergeekdeveloper.aptigrill.R;
import com.supergeekdeveloper.aptigrill.model.ProblemTypeModel;

import java.util.ArrayList;

/**
 * Created by shubhamjuneja11 on 16/10/17.
 */

public class ProblemTypeAdapter extends RecyclerView.Adapter<ProblemTypeAdapter.MyViewHolder> {
    ArrayList<ProblemTypeModel> al;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.problemtypelayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProblemTypeModel problem=al.get(position);
        holder.name.setText(problem.getName());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);

        }

    }
}
