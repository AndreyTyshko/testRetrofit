package com.example.testretrofit.model;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testretrofit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static androidx.core.graphics.drawable.IconCompat.getResources;

class ListAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_city,parent,false);
        return new ListViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder  {

        private TextView mTextView;

        public  ListViewHolder(View itemView){
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.cityName);
        }
            public void bindView (int position){

                //ArrayList<String> myResArrayList = new ArrayList<String>();
                //Resources res = getResources();
                List<Integer> myArrayList = Arrays.asList(R.array.cityNames);
                int pos = myArrayList.get(position);
                mTextView.setText(myArrayList.get(pos));
            }
    }
}
