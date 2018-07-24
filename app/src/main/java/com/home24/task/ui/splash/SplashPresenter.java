package com.home24.task.ui.splash;


import com.home24.task.data.dataManager.DataManager;
import com.home24.task.ui.base.BasePresenter;
import com.home24.task.utils.rx.SchedulerProvider;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Alaeddine Khoudi .
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    SplashPresenter(SchedulerProvider schedulerProvider,
                    CompositeDisposable compositeDisposable,
                    DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        startActivityWithDelay();
    }

    private void startActivityWithDelay() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 2000);
    }

    private void nextActivity() {
        getMvpView().openStartActivity();
    }

}


