package com.ppodgorski.verificationtask.manager;

import com.ppodgorski.verificationtask.model.Data;
import com.ppodgorski.verificationtask.network.ApiService;
import com.ppodgorski.verificationtask.utils.Const;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;


public class DataManager {

    @Inject
    ApiService mApiService;

    private List<String> mDataList;

    @Inject
    DataManager() {
        mDataList = new ArrayList<>();
    }

    public void updateDataList(String data) {
        mDataList.add(data);
        if (mDataList.size() > Const.C) {
            sendData();
        }
    }

    private void sendData() {
        Call<Void> call = mApiService.sendData(new Data(mDataList));
        try {
            Response<Void> response = call.execute();
            handleResponse(response);
        } catch (IOException e) {
            Timber.d(e);
        }
    }

    private void handleResponse(Response<Void> response) {
        if (response.isSuccessful()) {
            mDataList.clear();
        }
    }

}
