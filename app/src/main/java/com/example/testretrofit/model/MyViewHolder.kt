package com.example.testretrofit.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.R

class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

     var cityName: TextView
     var temperature:TextView
     //var image:ImageView

     init {
         cityName=itemView.findViewById(R.id.cityName)
         temperature=itemView.findViewById(R.id.temperature)
         //image=itemView.findViewById(R.id.sunnyImageView)
     }
}