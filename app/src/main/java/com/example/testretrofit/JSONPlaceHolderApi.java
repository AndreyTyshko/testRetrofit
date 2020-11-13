package com.example.testretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("data/2.5/weather?&lang=ru")
    Call<PostResponse> getPostWithID( @Query("q") String q, @Query("APPID") String AppId,  @Query("units") String units);
}
