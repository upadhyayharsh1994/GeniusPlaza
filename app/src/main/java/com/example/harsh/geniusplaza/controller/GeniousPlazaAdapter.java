package com.example.harsh.geniusplaza.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harsh.geniusplaza.R;

import java.util.List;
import com.example.harsh.geniusplaza.models.Data;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GeniousPlazaAdapter extends RecyclerView.Adapter<GeniousPlazaHolder> {
    private List<Data> dataList;

    public GeniousPlazaAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public GeniousPlazaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_adapter, viewGroup, false);

        return new GeniousPlazaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeniousPlazaHolder gp_holder, int i) {

        gp_holder.onBind(dataList.get(i));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
