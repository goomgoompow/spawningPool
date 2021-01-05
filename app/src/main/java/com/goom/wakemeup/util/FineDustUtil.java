package com.goom.wakemeup.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FineDustUtil {
    private FineDustApi mGetApi;

    public FineDustUtil() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FineDustApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mGetApi = retrofit.create(FineDustApi.class);
    }

    public FineDustApi getApi() {
        return mGetApi;
    }
}
