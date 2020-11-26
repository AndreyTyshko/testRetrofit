package com.example.testretrofit.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.testretrofit.R;

public class FragmentMain extends AppCompatActivity {

    Fragment mFragment1;
    Fragment mFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mFragment1 = new Fragment();
        mFragment2 = new Fragment();
    }
}