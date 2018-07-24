package com.home24.task.data.dataManager.network;

import com.home24.task.data.dataManager.network.model.ArticleRequest;
import com.home24.task.data.dataManager.network.model.ArticleResponse;


import io.reactivex.Observable;

/**
 * Created by Alaeddine Khoudi .
 */

public interface ApiHelper {

    Observable<ArticleResponse> doArticlesListApiCall(ArticleRequest articleRequest);

}
