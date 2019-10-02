package com.example.harsh.geniusplaza.models;

import java.util.List;

public class UserDetails {

    private int page;
    private int per_page;
    private int total;

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }
}
