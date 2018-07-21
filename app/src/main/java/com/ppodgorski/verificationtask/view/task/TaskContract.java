package com.ppodgorski.verificationtask.view.task;

import com.ppodgorski.verificationtask.view.base.BasePresenter;
import com.ppodgorski.verificationtask.view.base.BaseView;

public interface TaskContract {

    interface View extends BaseView<Presenter> {

        void showTaskStarted();
        void showTaskStopped();
    }

    interface Presenter extends BasePresenter<View> {

        void startTask();
        void stopTask();
    }

}
