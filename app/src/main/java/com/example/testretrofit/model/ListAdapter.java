package com.example.testretrofit.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testretrofit.PostResponse;
import com.example.testretrofit.R;

import java.util.ArrayList;


class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    //public static long z;
    private Context context;
    private ArrayList<PostResponse> items = new ArrayList<>();
    //private Context mContext;


    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_city, parent, false);
        context = parent.getContext();
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ListViewHolder holder, final int position) {

        holder.mTextView.setText(items.get(position).name);
        holder.mTextViewTemperature.setText(String.valueOf(items.get(position).main.temp));
        holder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.btnMenu);
                popupMenu.inflate(R.menu.option_menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.item_add:


                                Toast.makeText(context, "add", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.item_delete:
                               items.remove(position);
                               notifyDataSetChanged();
                               Toast.makeText(context,"del",Toast.LENGTH_LONG).show();
                               break;
                            default:
                                break;
                        }

                        return false;
                    }
                });


                popupMenu.show();
            }
        });

    }

    public void setItems(ArrayList<PostResponse> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private TextView mTextViewTemperature;
        private TextView btnMenu;


        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.viewholder_cityName);
            mTextViewTemperature = itemView.findViewById(R.id.temperature);
            btnMenu = itemView.findViewById(R.id.btn_menu);

        }
    }
}
