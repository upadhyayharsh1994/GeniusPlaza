package com.example.harsh.geniusplaza.networking;

public class ApiUtil {

    private static final String BASE_URL = "https://reqres.in/api/";

    public static ApiInterface getApiService() {

        return ApiClient.getRetrofit(BASE_URL).create(ApiInterface.class);
    }
}
