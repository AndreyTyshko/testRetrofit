package com.example.testretrofit.model;

class Item {
    private String city;
    private float temperature;

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
}

