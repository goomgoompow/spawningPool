package com.goom.wakemeup.finedust;

import com.goom.wakemeup.FineDust;
import com.goom.wakemeup.data.FineDustRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//view의 역할만
// 복잡한 logic 이곳에 들어감
public class FineDustPresenter implements FineDustContract.UserActionsListener {

    private final FineDustRepository mRepository;
    private final FineDustContract.View mView;

    public FineDustPresenter(FineDustRepository repository, FineDustContract.View view) {
        this.mRepository = repository;
        this.mView = view;
    }

    @Override
    public void loadFineDustData() {
        if(mRepository.isAvailable()){
            mRepository.getFineDustData(new Callback<FineDust>() {
                @Override
                public void onResponse(Call<FineDust> call, Response<FineDust> response) {
                    mView.showFineDustResult(response.body());
                    mView.loadingEnd();
                }

                @Override
                public void onFailure(Call<FineDust> call, Throwable t) {
                    mView.showLoadError(t.getLocalizedMessage());
                    mView.loadingEnd();
                }
            });
        }
    }
}
