package com.home24.task.di.module;

import android.app.Application;
import android.content.Context;


import com.home24.task.R;
import com.home24.task.data.dataManager.AppDataManager;
import com.home24.task.data.dataManager.DataManager;
import com.home24.task.data.dataManager.db.AppDbHelper;
import com.home24.task.data.dataManager.db.DbHelper;
import com.home24.task.data.dataManager.network.ApiCall;
import com.home24.task.data.dataManager.network.ApiHelper;
import com.home24.task.data.dataManager.network.AppApiHelper;
import com.home24.task.data.dataManager.pref.AppPreferenceHelper;
import com.home24.task.data.dataManager.pref.PreferenceHelper;
import com.home24.task.di.ApplicationContext;
import com.home24.task.di.DatabaseInfo;
import com.home24.task.di.PreferenceInfo;
import com.home24.task.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Alaeddine Khoudi .
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context providesContext() {
        return application;
    }

    @Provides
    Application providesApplication() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String providesDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @DatabaseInfo
    Integer providesDatabaseVersion() {
        return AppConstants.DB_VERSION;
    }

    @Provides
    @PreferenceInfo
    String providesSharedPrefName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager providesDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

   /* @Provides
    @Singleton
    DbHelper providesDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }*/

    @Provides
    @Singleton
    ApiHelper providesApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providesPreferenceHelper(AppPreferenceHelper appPreferenceHelper) {
        return appPreferenceHelper;
    }

    @Provides
    @Singleton
    ApiCall providesApiCall() {
        return ApiCall.Factory.create();
    }



    @Provides
    @Singleton
    CalligraphyConfig providesCalligraphyConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }


}
