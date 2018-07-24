package com.home24.task.ui.select;


import com.home24.task.R;
import com.home24.task.data.dataManager.DataManager;
import com.home24.task.data.dataManager.network.model.ArticleRequest;
import com.home24.task.ui.base.BasePresenter;
import com.home24.task.utils.rx.SchedulerProvider;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

import static com.home24.task.utils.AppConstants.LIMIT;

/**
 * Created by Alaeddine Khoudi .
 */

public class SelectPresenter<V extends SelectMvpView> extends BasePresenter<V>
        implements SelectMvpPresenter<V> {

    @Inject
    public SelectPresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable,
                         DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }



    @Override
    public void fetchArticleList() {


        if (!getMvpView().isNetworkConnected()) {
            if (!isViewAttached())
                return;
            getMvpView().onError(R.string.no_internet);
            return;
        }
            getMvpView().showLoading();

            getCompositeDisposable().add(
                    getDataManager().doArticlesListApiCall(new ArticleRequest("de_DE",LIMIT))
                            .subscribeOn(getSchedulerProvider().io())
                            .observeOn(getSchedulerProvider().ui())
                            .subscribe(response -> {
                                if (!isViewAttached())
                                    return;

                                getMvpView().hideLoading();


                                if (response.getEmbedded().getArticles() != null && response.getEmbedded().getArticles().size() > 0)
                                {
                                    getMvpView().fetchedArticles(response.getEmbedded().getArticles());
                                    getMvpView().showMainView();
                                }
                            }, throwable -> {
                                if (!isViewAttached())
                                    return;

                                getMvpView().hideLoading();
                                getMvpView().onError(R.string.could_not_fetch_items);
                            })
            );

    }


}
