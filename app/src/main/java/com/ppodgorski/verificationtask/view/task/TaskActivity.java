package com.ppodgorski.verificationtask.view.task;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import com.ppodgorski.verificationtask.R;
import com.ppodgorski.verificationtask.utils.PermissionUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class TaskActivity extends DaggerAppCompatActivity implements TaskContract.View {

    private static final int REQUEST_LOCATION = 0;

    @BindView(R.id.status_text_view)
    TextView mStatusTextView;

    @Inject
    TaskPresenter mPresenter;

    @OnClick(R.id.start_button)
    public void startButtonClicked() {
        if (PermissionUtils.isLocationPermissionGranted(this)) {
            mPresenter.startTask();
        } else {
            requestLocationPermission();
        }
    }

    @OnClick(R.id.stop_button)
    public void stopButtonClicked() {
        mPresenter.stopTask();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout();
        mPresenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public void showTaskStarted() {
        mStatusTextView.setText(getString(R.string.task_started));
    }

    @Override
    public void showTaskStopped() {
        mStatusTextView.setText(getString(R.string.task_stopped));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == REQUEST_LOCATION && PermissionUtils.verifyPermission(grantResults)) {
            mPresenter.startTask();
        }
    }

    private void setupLayout() {
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_LOCATION);
    }

}
