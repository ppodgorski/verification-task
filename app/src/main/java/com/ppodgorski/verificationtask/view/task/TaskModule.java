package com.ppodgorski.verificationtask.view.task;

import com.ppodgorski.verificationtask.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class TaskModule {

    @ActivityScoped
    @Binds
    abstract TaskContract.Presenter taskPresenter(TaskPresenter presenter);

}
