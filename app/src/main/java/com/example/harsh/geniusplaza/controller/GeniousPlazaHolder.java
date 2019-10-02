package com.example.harsh.geniusplaza.controller;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harsh.geniusplaza.R;
import com.example.harsh.geniusplaza.Utility.CircularImageView;
import com.squareup.picasso.Picasso;
import com.example.harsh.geniusplaza.models.Data;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GeniousPlazaHolder extends RecyclerView.ViewHolder {


    private CircularImageView ivProfile;
    private TextView firstName,lastName;


    public GeniousPlazaHolder(@NonNull View itemView) {
        super(itemView);

        firstName = itemView.findViewById(R.id.tv_firstName);
        lastName = itemView.findViewById(R.id.tv_lastName);
        ivProfile = itemView.findViewById(R.id.iv_profile_pic);
    }

    public void onBind(Data data) {

        firstName.setText(data.getFirst_name());
        lastName.setText(data.getLast_name());

        Picasso.with(itemView.getContext())
                .load(data.getAvatar())
                .placeholder(R.drawable.user_icon)
                .error(R.drawable.user_icon)
                .into(ivProfile);
    }
}
