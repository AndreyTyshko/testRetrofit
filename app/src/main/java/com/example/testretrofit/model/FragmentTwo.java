package com.example.testretrofit.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testretrofit.R;

public class FragmentTwo extends Fragment {


    public FragmentTwo() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewList);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
       /* return view;
        //FragmentActivity c = getActivity();
        mRecyclerView = (RecyclerView)View.findViewById(R.id.recyclerView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new RecyclerAdapter());
        return view;*/


    }


    private class MyViewHoler {

        TextView cityTextView;

    }
}
