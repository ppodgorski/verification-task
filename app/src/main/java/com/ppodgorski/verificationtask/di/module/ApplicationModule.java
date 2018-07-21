package com.ppodgorski.verificationtask.di.module;

import android.app.Application;
import android.content.Context;
import android.os.BatteryManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import static android.content.Context.BATTERY_SERVICE;

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Singleton
    static BatteryManager provideBatteryManager(Application application) {
        return (BatteryManager) application.getSystemService(BATTERY_SERVICE);
    }

}
