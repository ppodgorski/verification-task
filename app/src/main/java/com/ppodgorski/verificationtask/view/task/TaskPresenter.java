package com.ppodgorski.verificationtask.view.task;


import com.ppodgorski.verificationtask.di.scope.ActivityScoped;
import com.ppodgorski.verificationtask.manager.TaskManager;

import javax.inject.Inject;

@ActivityScoped
public class TaskPresenter implements TaskContract.Presenter {

    private TaskManager mTaskManager;

    private TaskContract.View mTaskView;

    @Inject
    TaskPresenter(TaskManager taskManager) {
        mTaskManager = taskManager;
    }

    @Override
    public void takeView(TaskContract.View view) {
        mTaskView = view;
    }

    @Override
    public void dropView() {
        mTaskManager.stopTask();
        mTaskView = null;
    }

    @Override
    public void startTask() {
        mTaskManager.startTask();
        mTaskView.showTaskStarted();
    }

    @Override
    public void stopTask() {
        mTaskManager.stopTask();
        mTaskView.showTaskStopped();
    }

}
