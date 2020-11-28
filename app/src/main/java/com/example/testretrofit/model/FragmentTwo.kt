package com.example.testretrofit.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.R

internal class FragmentTwo : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.two_fragment, container, false)

        val recyclerView: RecyclerView = view?.findViewById(R.id.recyclerView)!!

        val recyclerAdapter: RecyclerAdapter.MyViewHolder


        //recyclerView.setHasFixedSize(true)
        //recyclerView.layoutManager = LinearLayoutManager(context)*/

        //recyclerView.layoutManager = LinearLayoutManager(context)
        //recyclerView.adapter = RecyclerAdapter(getListCity())

    }

    /* private fun fillList(): List<String>{
         val data = mutableListOf<String>()
         (0..30).forEach {i->data.add("\$i element")}
         return data
     }
 */
    //

    //val adapter = RecyclerAdapter(getListCity())
}