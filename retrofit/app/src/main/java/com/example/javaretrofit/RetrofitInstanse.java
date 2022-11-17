package com.example.javaretrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitInstanse {
    public static Retrofit retrofit;

    public static OkHttpClient okHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient())
                    .baseUrl("https://run.mocky.io")
                    .build();
        }
        return retrofit;

    }

    public static HouseService getHouseService() {
        return retrofit.create(HouseService.class);
    }
}
