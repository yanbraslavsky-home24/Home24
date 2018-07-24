package com.home24.task.ui.splash;



import com.home24.task.data.dataManager.DataManager;
import com.home24.task.ui.splash.SplashMvpView;
import com.home24.task.ui.splash.SplashPresenter;
import com.home24.task.utils.rx.SchedulerProvider;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


import io.reactivex.disposables.CompositeDisposable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Alaeddine Khoudi.
 */

@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    @Mock
    SplashMvpView splashMvpView;


    @Mock
    DataManager dataManager;

    @Mock
    SchedulerProvider schedulerProvider;

    private SplashPresenter<SplashMvpView> splashPresenter;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        splashPresenter = new SplashPresenter<>(
                schedulerProvider,
                compositeDisposable,
                dataManager);
    }

    @Test
    public void nextActivity() throws InterruptedException {
       splashPresenter.onAttach(splashMvpView);
        Thread.sleep(2000);
        verify(splashMvpView).openStartActivity();
    }



}