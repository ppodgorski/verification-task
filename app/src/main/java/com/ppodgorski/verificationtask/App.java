package com.ppodgorski.verificationtask;

import com.ppodgorski.verificationtask.di.AppComponent;
import com.ppodgorski.verificationtask.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;


public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        plantTimber();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

    private void plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
