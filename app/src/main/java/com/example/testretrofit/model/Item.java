package com.example.testretrofit.model;

import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testretrofit.R;

class Item  extends AppCompatActivity {
    private String city;
    private float temperature;

    String[] cityList = getResources().getStringArray(R.array.cityNames);

    public Item(String city, float temperature) {
        this.city = city;
        this.temperature = temperature;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Item{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public String[] getCityList() {
        return cityList;
    }

    public void setCityList(String[] cityList) {
        this.cityList = cityList;
    }
}

