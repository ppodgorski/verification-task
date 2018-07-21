package com.ppodgorski.verificationtask.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.ppodgorski.verificationtask.utils.Const;

import javax.inject.Inject;

public class LocationManager {

    @Inject
    Context mContext;

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;

    @Inject
    LocationManager() {

    }

    @SuppressLint("MissingPermission")
    public void startLocationUpdates(LocationCallback locationCallback, Looper looper) {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext);
        createLocationRequest();
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, locationCallback, looper);
    }

    public void stopLocationUpdates(LocationCallback locationCallback) {
        mFusedLocationClient.removeLocationUpdates(locationCallback);
    }

    private void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(Const.A * 1000);
        mLocationRequest.setFastestInterval(Const.A * 1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

}
