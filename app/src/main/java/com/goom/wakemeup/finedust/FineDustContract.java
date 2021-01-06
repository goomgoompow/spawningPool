package com.goom.wakemeup.finedust;

import com.goom.wakemeup.FineDust;

public class FineDustContract {
    interface View{
        void showFineDustResult(FineDust fineDust);
        void showLoadError(String message);
        void loadingStart();
        void loadingEnd();
        void reload(double lat, double lng);
    }

    interface UserActionsListener{
        void loadFineDustData();
    }
}
