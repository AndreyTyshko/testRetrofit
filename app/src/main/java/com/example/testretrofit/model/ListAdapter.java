package com.example.testretrofit.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testretrofit.R;

import java.util.ArrayList;
import java.util.List;


class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<String> items = new ArrayList<>();

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_city, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        holder.mTextView.setText(items.get(position));
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.viewholder_cityName);
        }
    }
}
