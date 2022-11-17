package com.example.javaretrofit;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        houseAPI();
    }


    public void houseAPI() {

        RetrofitInstanse.retrofit();
        Call<HouseDto> call;
        call = RetrofitInstanse.houseService.getHouseList();

        call.enqueue(new Callback<HouseDto>() {
            @Override
            public void onResponse(Call<HouseDto> call, Response<HouseDto> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                Log.d("MainActivity", response.toString());
            }

            @Override
            public void onFailure(Call<HouseDto> call, Throwable t) {

            }
        });
    }
}