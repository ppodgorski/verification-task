package com.ppodgorski.verificationtask.manager.handler;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.ppodgorski.verificationtask.manager.LocationManager;

public class LocationHandler extends Handler {

    private DataHandler mDataHandler;
    private LocationManager mLocationManager;

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult != null) {
                Location location = locationResult.getLastLocation();
                sendResultToDataThread(location.toString());
            }
        };
    };


    public LocationHandler(Looper looper, DataHandler dataHandler, LocationManager locationManager) {
        super(looper);
        mDataHandler = dataHandler;
        mLocationManager = locationManager;
    }

    public void start() {
        mLocationManager.startLocationUpdates(mLocationCallback, getLooper());
    }

    public void stop() {
        mLocationManager.stopLocationUpdates(mLocationCallback);
    }

    private void sendResultToDataThread(String result) {
        Message message = mDataHandler.obtainMessage();
        message.obj = result;
        mDataHandler.sendMessage(message);
    }

}
