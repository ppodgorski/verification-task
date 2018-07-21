package com.ppodgorski.verificationtask.view.base;

public interface BasePresenter<T> {
    void takeView(T view);
    void dropView();
}
