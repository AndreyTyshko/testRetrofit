package com.example.testretrofit.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.R


class RecyclerAdapter(private val values: List<String>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.card_city, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {

        var item = itemList
        holder.cityTW?.text = values[position]
        //holder.temperatureTW?.text = "55"
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cityTW: TextView? = null
        //var temperatureTW: TextView? = null

        init {
            cityTW = itemView?.findViewById(R.id.cityName)
            //temperatureTW = itemView?.findViewById(R.id.temperature)
        }
    }
}












