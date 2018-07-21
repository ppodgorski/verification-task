package com.ppodgorski.verificationtask.di;

import android.app.Application;

import com.ppodgorski.verificationtask.App;
import com.ppodgorski.verificationtask.di.module.ActivityBindingModule;
import com.ppodgorski.verificationtask.di.module.ApiModule;
import com.ppodgorski.verificationtask.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        ApiModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(App application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
