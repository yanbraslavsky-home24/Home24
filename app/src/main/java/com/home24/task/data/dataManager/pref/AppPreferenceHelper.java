package com.home24.task.data.dataManager.pref;

import android.content.Context;
import android.content.SharedPreferences;


import com.home24.task.di.ApplicationContext;
import com.home24.task.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Alaeddine Khoudi .
 */

@Singleton
public class AppPreferenceHelper implements PreferenceHelper {


    private SharedPreferences prefs;

    @Inject
    AppPreferenceHelper(@ApplicationContext Context context,
                        @PreferenceInfo String prefName) {
        prefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

}
