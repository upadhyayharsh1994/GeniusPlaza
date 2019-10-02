package com.example.harsh.geniusplaza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.harsh.geniusplaza.controller.GeniousPlazaAdapter;
import com.example.harsh.geniusplaza.models.Data;
import com.example.harsh.geniusplaza.models.UserDetails;
import com.example.harsh.geniusplaza.networking.ApiClient;
import com.example.harsh.geniusplaza.networking.ApiUtil;
import com.example.harsh.geniusplaza.networking.ApiInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RETROFIT";
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    private List<Data> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_genious);
        floatingActionButton = findViewById(R.id.fab);
        getUserCall();

        setFloatingActionButton();

    }


    public void getUserCall() {
        ApiInterface apiInterface =ApiUtil.getApiService();
        apiInterface.getUsers(12).enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {

                UserDetails userDetails = response.body();
                Log.e(TAG, userDetails.getData().get(0).getFirst_name());
                users = userDetails.getData();
                setRecyclerView(users);

            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {

                t.printStackTrace();

            }
        });
    }

    public void setRecyclerView(List<Data> dataModel) {
        recyclerView = findViewById(R.id.rv_genious);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new GeniousPlazaAdapter(dataModel));

    }

    public void setFloatingActionButton() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newUserIntent = new Intent(MainActivity.this, AddUser.class);
                startActivity(newUserIntent);
            }
        });
    }
}
