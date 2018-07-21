package com.ppodgorski.verificationtask.manager.handler;

import android.os.BatteryManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.ppodgorski.verificationtask.utils.Const;

public class BatteryHandler extends Handler {

    private DataHandler mDataHandler;
    private BatteryManager mBatteryManager;

    private Runnable mBatteryRunnable = new Runnable() {
        @Override
        public void run() {
            sendResultToDataThread(getBatteryLevel());
            postDelayed(this, Const.B * 1000);
        }
    };

    public BatteryHandler(Looper looper, DataHandler dataHandler, BatteryManager batteryManager) {
        super(looper);
        mDataHandler = dataHandler;
        mBatteryManager = batteryManager;
    }

    public void start() {
        post(mBatteryRunnable);
    }

    private void sendResultToDataThread(String result) {
        Message message = mDataHandler.obtainMessage();
        message.obj = result;
        mDataHandler.sendMessage(message);
    }

    private String getBatteryLevel() {
        Integer batteryLevel = mBatteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        return batteryLevel.toString() + "%";
    }

}
