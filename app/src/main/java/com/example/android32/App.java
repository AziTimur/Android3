package com.example.android32;
import android.app.Application;

import com.example.android32.retrofit.data.remote.Ghibliapi;
import com.example.android32.retrofit.data.remote.RetrofitClient;
import com.example.android32.retrofit.data.repositories.GhibliRepository;


public class App extends Application {
    public static Ghibliapi api;
    public  static GhibliRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        api=new RetrofitClient().provideGhibli();
        repository=new GhibliRepository();
    }
}
