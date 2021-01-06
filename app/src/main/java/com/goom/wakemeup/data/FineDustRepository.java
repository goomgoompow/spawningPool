package com.goom.wakemeup.data;

import com.goom.wakemeup.FineDust;

import retrofit2.Callback;

public interface FineDustRepository {
    boolean isAvailable();
    void getFineDustData(Callback<FineDust> callback);
}
