package com.home24.task.ui.review;


import com.home24.task.data.dataManager.DataManager;
import com.home24.task.ui.base.BasePresenter;
import com.home24.task.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Alaeddine Khoudi .
 */

public class ReviewPresenter<V extends ReviewMvpView> extends BasePresenter<V>
        implements ReviewMvpPresenter<V> {

    @Inject
    public ReviewPresenter(SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable,
                           DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }


}
