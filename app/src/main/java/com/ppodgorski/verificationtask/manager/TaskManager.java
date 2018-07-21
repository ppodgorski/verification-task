package com.ppodgorski.verificationtask.manager;

import android.os.BatteryManager;
import android.os.HandlerThread;

import com.ppodgorski.verificationtask.manager.handler.BatteryHandler;
import com.ppodgorski.verificationtask.manager.handler.DataHandler;
import com.ppodgorski.verificationtask.manager.handler.LocationHandler;

import javax.inject.Inject;

public class TaskManager {

    @Inject
    LocationManager mLocationManager;

    @Inject
    BatteryManager mBatteryManager;

    @Inject
    DataManager mDataManager;

    private boolean mIsTaskRunning;
    private HandlerThread mDataThread;
    private HandlerThread mLocationThread;
    private HandlerThread mBatteryThread;
    private DataHandler mDataHandler;
    private LocationHandler mLocationHandler;

    @Inject
    TaskManager() {

    }

    public void startTask() {
        if (!mIsTaskRunning) {
            mIsTaskRunning = true;
            startThreads();
        }
    }

    public void stopTask() {
        if (mIsTaskRunning) {
            mIsTaskRunning = false;
            stopThreads();
        }
    }

    private void startThreads() {
        startDataThread();
        startLocationThread();
        startBatteryThread();
    }

    private void startDataThread() {
        mDataThread = new HandlerThread("dataThread");
        mDataThread.start();
        mDataHandler = new DataHandler(mDataThread.getLooper(), mDataManager);
    }

    private void startLocationThread() {
        mLocationThread = new HandlerThread("locationThread");
        mLocationThread.start();
        mLocationHandler = new LocationHandler(mLocationThread.getLooper(), mDataHandler, mLocationManager);
        mLocationHandler.start();
    }

    private void startBatteryThread() {
        mBatteryThread = new HandlerThread("batteryThread");
        mBatteryThread.start();
        BatteryHandler batteryHandler = new BatteryHandler(mBatteryThread.getLooper(), mDataHandler, mBatteryManager);
        batteryHandler.start();
    }

    private void stopThreads() {
        mLocationHandler.stop();
        mDataThread.quit();
        mLocationThread.quit();
        mBatteryThread.quit();
    }

}
