package com.ppodgorski.verificationtask.view.task;

import com.ppodgorski.verificationtask.manager.TaskManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaskPresenterTest {

    @Mock
    private TaskManager mTaskManager;

    @Mock
    private TaskContract.View mView;


    private TaskPresenter mTaskPresenter;

    @Before
    public void setup() {
        mTaskPresenter = new TaskPresenter(mTaskManager);
        mTaskPresenter.takeView(mView);
    }

    @Test
    public void startTaskTest() {
        mTaskPresenter.startTask();
        verify(mTaskManager).startTask();
        verify(mView).showTaskStarted();
    }

    @Test
    public void stopTaskTest() {
        mTaskPresenter.stopTask();
        verify(mTaskManager).stopTask();
        verify(mView).showTaskStopped();
    }


}
