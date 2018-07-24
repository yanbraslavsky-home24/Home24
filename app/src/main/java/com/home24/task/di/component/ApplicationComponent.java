package com.home24.task.di.component;

import android.app.Application;
import android.content.Context;

import com.home24.task.MyApp;
import com.home24.task.data.dataManager.DataManager;
import com.home24.task.di.ApplicationContext;
import com.home24.task.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alaeddine Khoudi .
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();


    void inject(MyApp myApp);
}
