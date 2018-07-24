package com.home24.task;

import android.app.Application;


import com.home24.task.di.component.ApplicationComponent;
import com.home24.task.di.component.DaggerApplicationComponent;
import com.home24.task.di.module.ApplicationModule;
import com.home24.task.utils.AppLogger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Alaeddine Khoudi .
 */

public class MyApp extends Application {

    @Inject
    CalligraphyConfig calligraphyConfig;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //Instantiate ApplicationComponent
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);

        AppLogger.init();

        CalligraphyConfig.initDefault(calligraphyConfig);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
