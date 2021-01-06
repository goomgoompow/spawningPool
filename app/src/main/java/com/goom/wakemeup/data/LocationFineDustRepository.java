package com.goom.wakemeup.data;

import com.goom.wakemeup.FineDust;
import com.goom.wakemeup.util.FineDustUtil;

import retrofit2.Callback;

public class LocationFineDustRepository implements FineDustRepository{
    private FineDustUtil mFineDustUtil;
    private double mLatitude;
    private double mLongitude;


    public LocationFineDustRepository() {
        mFineDustUtil = new FineDustUtil();
    }

    public LocationFineDustRepository(double latitude, double longitude) {
        this();
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    @Override
    public boolean isAvailable() {
        if(mLatitude != 0.0 && mLongitude != 0.0) return true;
        return false;
    }

    @Override
    public void getFineDustData(Callback<FineDust> callback) {
        mFineDustUtil.getApi().getFineDust(mLatitude,mLongitude).enqueue(callback);
    }
}
