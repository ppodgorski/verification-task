package com.ppodgorski.verificationtask.manager.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.ppodgorski.verificationtask.manager.DataManager;

import timber.log.Timber;

public class DataHandler extends Handler {

    private DataManager mDataManager;

    public DataHandler(Looper looper, DataManager dataManager) {
        super(looper);
        mDataManager = dataManager;
    }

    @Override
    public void handleMessage(Message msg) {
        String data = (String) msg.obj;
        Timber.d("DataHandler message: %s", data);
        mDataManager.updateDataList(data);
    }

}
