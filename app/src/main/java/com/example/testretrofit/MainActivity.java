package com.example.testretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;




public class MainActivity extends AppCompatActivity {

    public static String AppId = "4240241801da69bd61e3b433199e86d3";
    //public static String lat = "55.04";
    //public static String lon = "82.93";
    public static String units = "metric";
    public static String q ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner mSpinner = findViewById(R.id.spinner2);
        final ArrayAdapter<?> adapter =  ArrayAdapter.createFromResource(this, R.array.cityNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        mSpinner.setAdapter(adapter);

        final TextView mTextView = findViewById(R.id.textView);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //q =  mEditText.getText().toString();
                q =  mSpinner.getSelectedItem().toString();




                JSONPlaceHolderApi service = NetworkService.getRetrofitInstance().create(JSONPlaceHolderApi.class);
                //Call<PostResponse> call = service.getPostWithID(lat, lon, AppId);
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
                                    "City: " +
                                    postResponse.name;


                            mTextView.setText(stringBuilder);
                        }


                        //ArrayList<PostResponse>  posts = new ArrayList<>();
                        //mTextView.setText((CharSequence) posts);



                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {
                        mTextView.setText(t.getMessage());
                    }


                });

            }
        });


       /* NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID()
                .enqueue(new Callback<JSONPlaceHolderApi.Post>() {
                    @Override
                    public void onResponse(@NonNull Call<JSONPlaceHolderApi.Post> call, @NonNull Response<JSONPlaceHolderApi.Post> response) {
                        JSONPlaceHolderApi.Post post = response.body();

                        mTextView.append(post.getId() + "\n");
                        mTextView.append(post.getUserId() + "\n");
                        mTextView.append(post.getTitle() + "\n");
                        mTextView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<JSONPlaceHolderApi.Post> call, @NonNull Throwable t) {

                        mTextView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
*/






    }
}
