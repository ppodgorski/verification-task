package com.ppodgorski.verificationtask.di.module;

import com.ppodgorski.verificationtask.di.scope.ActivityScoped;
import com.ppodgorski.verificationtask.view.task.TaskActivity;
import com.ppodgorski.verificationtask.view.task.TaskModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = TaskModule.class)
    abstract TaskActivity taskActivity();

}
