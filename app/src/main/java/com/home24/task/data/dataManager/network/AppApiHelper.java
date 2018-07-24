package com.home24.task.data.dataManager.network;


import com.home24.task.data.dataManager.network.model.ArticleRequest;
import com.home24.task.data.dataManager.network.model.ArticleResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Alaeddine Khoudi .
 */

@Singleton
public class AppApiHelper implements ApiHelper{

    private ApiCall apiCall;

    @Inject
    AppApiHelper(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    @Override
    public Observable<ArticleResponse> doArticlesListApiCall(ArticleRequest articleRequest) {
        return apiCall.getArticles(articleRequest.getLanguage(),articleRequest.getLimit());
    }

}
