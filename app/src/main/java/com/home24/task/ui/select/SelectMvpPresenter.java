package com.home24.task.ui.select;


import com.home24.task.di.PerActivity;
import com.home24.task.ui.base.MvpPresenter;

/**
 * Created by Alaeddine Khoudi .
 */

@PerActivity
public interface SelectMvpPresenter<V extends SelectMvpView> extends MvpPresenter<V> {
    void fetchArticleList();
}
