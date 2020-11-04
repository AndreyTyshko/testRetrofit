package com.example.testretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    // private static NetworkService mInstance;
    public static String BaseUrl = "http://api.openweathermap.org/";

    private static Retrofit mRetrofit;


    public static Retrofit getRetrofitInstance() {
        if (mRetrofit == null) {
            mRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

}