package com.example.android32.retrofit.data.remote;

import com.example.android32.retrofit.data.models.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Ghibliapi {
    @GET("/films")
    public Call<List<Films>>getFilms();
}
