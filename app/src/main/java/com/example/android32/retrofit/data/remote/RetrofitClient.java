package com.example.android32.retrofit.data.remote;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final OkHttpClient okHttpClient= new OkHttpClient()
            .newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .addInterceptor(provideLoggingInterceptor()).build();

    private Interceptor provideLoggingInterceptor() {
        return  new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

    }
    private final Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Ghibliapi provideGhibli() {
        return  retrofit.create(Ghibliapi.class);
    }
}
