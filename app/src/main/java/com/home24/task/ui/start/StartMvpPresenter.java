package com.home24.task.ui.start;

import com.home24.task.di.PerActivity;
import com.home24.task.ui.base.MvpPresenter;
import com.home24.task.ui.splash.SplashMvpView;

/**
 * Created by Alaeddine Khoudi .
 */

@PerActivity
public interface StartMvpPresenter<V extends StartMvpView> extends MvpPresenter<V> {
}
