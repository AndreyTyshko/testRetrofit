package com.example.testretrofit.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testretrofit.JSONPlaceHolderApi;
import com.example.testretrofit.NetworkService;
import com.example.testretrofit.PostResponse;
import com.example.testretrofit.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<String> items = new ArrayList<>();
    public static String AppId = "4240241801da69bd61e3b433199e86d3";
    public static String units = "metric";
    public static String q = "Новосибирск";
    public static long z;


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
        private TextView mTextViewTemperature;


        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.viewholder_cityName);

            //q=itemView.get
            //q = "Novosibirsk";
            //q = mTextView.getText().toString();

            JSONPlaceHolderApi service = NetworkService.getRetrofitInstance().create(JSONPlaceHolderApi.class);
            q=
            Call<PostResponse> call = service.getPostWithID(q, AppId, units);
            call.enqueue(new Callback<PostResponse>() {
                @Override
                public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {

                    if (response.code() == 200) {
                        PostResponse postResponse = response.body();
                        assert postResponse != null;

                        mTextViewTemperature.setText(postResponse.name);
                    }
                }

                @Override
                public void onFailure(Call<PostResponse> call, Throwable t) {
                    mTextView.setText(t.getMessage());
                }
            });

        }
    }
}
