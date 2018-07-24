package com.home24.task.ui.start;


import com.home24.task.data.dataManager.DataManager;
import com.home24.task.ui.base.BasePresenter;
import com.home24.task.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Alaeddine Khoudi .
 */

public class StartPresenter<V extends StartMvpView> extends BasePresenter<V> implements StartMvpPresenter<V> {

    @Inject
    StartPresenter(SchedulerProvider schedulerProvider,
                   CompositeDisposable compositeDisposable,
                   DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }
}
