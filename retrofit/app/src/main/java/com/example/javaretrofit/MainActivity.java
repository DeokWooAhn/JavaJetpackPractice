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
        RetrofitInstanse.getInstance();
        Call<HouseDto> call;
        call = RetrofitInstanse.getHouseService().getHouseList();

        call.enqueue(new Callback<HouseDto>() {
            @Override
            public void onResponse(Call<HouseDto> call, Response<HouseDto> response) {
                if (response.isSuccessful()) {
                    HouseDto houseDto = response.body();
                    Log.d("메인", "성공");
                    return;
                }
            }
            @Override
            public void onFailure(Call<HouseDto> call, Throwable t) {
                Log.d("MainActivity", "실패");
            }
        });
    }
}