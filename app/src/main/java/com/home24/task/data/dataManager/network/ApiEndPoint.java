package com.home24.task.data.dataManager.network;


import com.home24.task.BuildConfig;
import com.home24.task.utils.AppConstants;

/**
 * Created by Alaeddine Khoudi.
 */

public final class ApiEndPoint {


    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL +
            "articles?appDomain=1";

    private ApiEndPoint() {
        //
    }
}
