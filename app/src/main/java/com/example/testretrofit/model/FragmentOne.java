package com.example.testretrofit.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testretrofit.JSONPlaceHolderApi;
import com.example.testretrofit.NetworkService;
import com.example.testretrofit.PostResponse;
import com.example.testretrofit.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOne extends Fragment {
    public static String AppId = "4240241801da69bd61e3b433199e86d3";
    public static String units = "metric";
     public static String q = "Новосибирск";

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.one_fragment, container, false);
       getData(q);
       return view;
    }

    private void getData(String q) {

        JSONPlaceHolderApi service = NetworkService.getRetrofitInstance().create(JSONPlaceHolderApi.class);
        Call<PostResponse> call = service.getPostWithID(q, AppId, units);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {

                if (response.code() == 200) {
                    PostResponse postResponse = response.body();

                    assert postResponse != null;

                    String stringBuilder =
                            "Temperature: " +
                            postResponse.main.temp +
                            "\n" +
                            "Temperature(Min): " +
                            postResponse.main.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            postResponse.main.temp_max +
                            "\n" +
                            "Humidity: " +
                            postResponse.main.humidity +
                            "\n" +
                            "Pressure: " +
                            postResponse.main.pressure
                            +
                            "\n" +
                            "City: " +
                            postResponse.name
                            +
                            "\n"+
                            "WindSpeed: " +
                            postResponse.wind.speed
                            +
                            "\n"+
                            "Country: " +
                            postResponse.sys.country
                            ;

                    TextView textView =(TextView) getView().findViewById(R.id.textView2);
                    textView.setText(stringBuilder);

                }
            }
            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });
    }
}
