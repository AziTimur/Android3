package com.example.android32.retrofit.data.repositories;
import androidx.lifecycle.MutableLiveData;

import com.example.android32.App;
import com.example.android32.retrofit.data.models.Films;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GhibliRepository {
    public MutableLiveData<List<Films>> getFilms(){
        MutableLiveData<List<Films>> films= new MutableLiveData<>();
        App.api.getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful()&response.body()!=null){
                    films.setValue(response.body());
                }else {
                    films.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                films.setValue(null);
            }
        });
        return films;
    }
}
