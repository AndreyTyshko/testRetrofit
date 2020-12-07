package com.example.testretrofit.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testretrofit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewList);
        ListAdapter listAdapter = new ListAdapter();
        listAdapter.setItems(new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.cityNames))));
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
