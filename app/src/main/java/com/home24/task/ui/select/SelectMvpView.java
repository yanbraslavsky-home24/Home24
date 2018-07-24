package com.home24.task.ui.select;

import com.home24.task.data.model.Article;
import com.home24.task.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by Alaeddine Khoudi .
 */

public interface SelectMvpView extends MvpView {

    void fetchedArticles(ArrayList<Article> articleList);

    void showMainView();


}
