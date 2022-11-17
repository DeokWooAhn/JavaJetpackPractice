package com.example.javaretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HouseService {

    @GET("/v3/b8384223-152e-4d1a-a90c-f793731e5715")
    Call<HouseDto> getHouseList();

}
