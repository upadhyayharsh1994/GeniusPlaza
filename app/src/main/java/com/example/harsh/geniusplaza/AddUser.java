package com.example.harsh.geniusplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.harsh.geniusplaza.models.PostDetails;
import com.example.harsh.geniusplaza.networking.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUser extends AppCompatActivity {
    PostDetails post;
    private final String TAG = "RESPONSE";
    EditText nameInput;
    EditText jobInput;
    Button createButton;
    ImageView closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        nameInput = findViewById(R.id.name_input);
        jobInput = findViewById(R.id.job_input);
        createButton = findViewById(R.id.button);
        closeButton = findViewById(R.id.iv_close);

        String name = nameInput.getText().toString();
        String job = jobInput.getText().toString();

        post = new PostDetails(name, job);

        setCreateButton();

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent close = new Intent(AddUser.this,MainActivity.class);
                startActivity(close);
            }
        });
    }

    public void postMethod() {


        ApiUtil.getApiService().createPost(post).enqueue(new Callback<PostDetails>() {
            @Override
            public void onResponse(Call<PostDetails> call, Response<PostDetails> response) {

                int result = response.code();

                if (!response.isSuccessful()) {
                    return;
                }


                PostDetails postDetails = response.body();

                Log.e(TAG, String.valueOf(result));

                String content = postDetails.getId();


                Toast.makeText(AddUser.this, "New User ID: " + content,
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(AddUser.this,MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<PostDetails> call, Throwable t) {

                t.printStackTrace();

            }
        });

    }

    public void setCreateButton() {

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postMethod();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",nameInput.getText().toString());
        outState.putString("job",jobInput.getText().toString());
    }

}
