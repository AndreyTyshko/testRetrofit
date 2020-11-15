package com.example.testretrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String AppId = "4240241801da69bd61e3b433199e86d3";
    public static String units = "metric";
    public static String q ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner mSpinner = findViewById(R.id.spinner2);
        final ImageView imageView = findViewById(R.id.imageSun);
        final ArrayAdapter<?> adapter =  ArrayAdapter.createFromResource(this, R.array.cityNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(adapter);

mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        final TextView mTextView = findViewById(R.id.textView);

        q =  mSpinner.getSelectedItem().toString();

        JSONPlaceHolderApi service = NetworkService.getRetrofitInstance().create(JSONPlaceHolderApi.class);
        Call<PostResponse> call = service.getPostWithID(q, AppId, units);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse( Call<PostResponse> call,  Response<PostResponse> response) {

                if (response.code()==200) {
                    PostResponse postResponse = response.body();
                    assert  postResponse !=null;

                    String stringBuilder = "Country: " +
                            postResponse.sys.country +
                            "\n" +
                            "Temperature: " +
                            postResponse.main.temp +
                            "\n" +
                            "Temperature(Min): " +
                            postResponse.main.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            postResponse.main.temp_max +
                            "\n" +
                            "Humidity: " +
                            postResponse.main.humidity +
                            "\n" +
                            "Pressure: " +
                            postResponse.main.pressure
                            +
                            "\n" +
                            "Clouds: " +
                            postResponse.clouds.all
                            +
                            "\n" +
                            "Wind: " +
                            postResponse.wind.speed
                            +
                            "\n" +
                            "City: " +
                            postResponse.name;


                    mTextView.setText(stringBuilder);
                   int sun= (int) postResponse.clouds.all;

                   if (sun <=20){
                       imageView.setImageResource(R.drawable.ic_sunny);
                   }
                   if (sun > 20 && sun < 80){
                       imageView.setImageResource(R.drawable.ic_sun_clouds);
                   }
                   if (sun >=80) {
                       imageView.setImageResource(R.drawable.ic_clouds);
                   }
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

    }
}
