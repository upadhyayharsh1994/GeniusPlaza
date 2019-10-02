package com.example.harsh.geniusplaza.networking;

import com.example.harsh.geniusplaza.models.PostDetails;
import com.example.harsh.geniusplaza.models.UserDetails;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users")
    Call<UserDetails> getUsers(@Query("per_page") int perPage);

    @POST("/api/users")
    Call<PostDetails> createPost(@Body PostDetails postDetails);
}
