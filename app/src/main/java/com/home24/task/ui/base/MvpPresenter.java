package com.home24.task.ui.base;


/**
 * Created by Alaeddine Khoudi .
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();
}
