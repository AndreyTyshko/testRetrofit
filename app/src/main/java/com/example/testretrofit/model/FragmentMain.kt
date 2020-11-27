package com.example.testretrofit.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testretrofit.R

class FragmentMain : AppCompatActivity() {
    var mFragment1: Fragment? = null
    var mFragment2: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
      /*  mFragment1 = Fragment()
        mFragment2 = Fragment()

        val  manager  = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_one, mFragment1!!)
        transaction.commit()
        transaction.replace(R.id.fragment_two, mFragment2!!)
        transaction.commit()*/

    }
}