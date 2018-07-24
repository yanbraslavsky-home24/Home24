package com.home24.task.data.dataManager;

import android.content.Context;
import com.home24.task.data.dataManager.network.ApiHelper;
import com.home24.task.data.dataManager.network.model.ArticleRequest;
import com.home24.task.data.dataManager.network.model.ArticleResponse;
import com.home24.task.data.dataManager.pref.PreferenceHelper;
import com.home24.task.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Alaeddine Khoudi .
 */

@Singleton
public class AppDataManager implements DataManager {


    private final Context context;
    private final PreferenceHelper preferenceHelper;
    private final ApiHelper apiHelper;

    @Inject
    AppDataManager(@ApplicationContext Context context,
                   PreferenceHelper preferenceHelper,
                   ApiHelper apiHelper) {

        this.context = context;
        this.preferenceHelper = preferenceHelper;
        this.apiHelper = apiHelper;
    }



    //DB:BLOG

   /* @Override
    public Observable<Long> insertArticle(Article article) {
        return dbHelper.insertArticle(article);
    }

    @Override
    public Observable<List<Long>> insertArticleList(List<Article> articleList) {
        return dbHelper.insertArticleList(articleList);
    }

    @Override
    public Observable<List<Article>> getArticleList() {
        return dbHelper.getArticleList();
    }

    @Override
    public Observable<Long> getArticleRecordCount() {
        return dbHelper.getArticleRecordCount();
    }

    @Override
    public Completable wipeArticleData() {
        return dbHelper.wipeArticleData();
    }
*/


    //API CALL:BLOG

    @Override
    public Observable<ArticleResponse> doArticlesListApiCall(ArticleRequest articleRequest) {
        return apiHelper.doArticlesListApiCall(articleRequest);
    }

}
