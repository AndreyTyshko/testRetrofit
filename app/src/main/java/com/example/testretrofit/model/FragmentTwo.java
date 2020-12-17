package com.example.testretrofit.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.testretrofit.JSONPlaceHolderApi;
import com.example.testretrofit.NetworkService;
import com.example.testretrofit.PostResponse;
import com.example.testretrofit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FragmentTwo extends Fragment {

    public static String AppId = "4240241801da69bd61e3b433199e86d3";
    public static String units = "metric";
    public static String q = "Новосибирск";
    private ListAdapter listAdapter;


    private ArrayList<PostResponse> items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewList);
        listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        getData("Новосибирск");
        return view;
    }

    private void getData(String cityName) {

        JSONPlaceHolderApi service = NetworkService.getRetrofitInstance().create(JSONPlaceHolderApi.class);
        Call<PostResponse> call = service.getPostWithID(cityName, AppId, units);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {

                if (response.code() == 200) {
                    PostResponse postResponse = response.body();
                    items.add(postResponse);
                    listAdapter.setItems(items);
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });
    }
}
