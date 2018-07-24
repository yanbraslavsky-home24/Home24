package com.home24.task.ui.start;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.home24.task.R;
import com.home24.task.ui.base.BaseActivity;
import com.home24.task.ui.select.SelectActivity;
import com.home24.task.ui.splash.SplashMvpPresenter;
import com.home24.task.ui.splash.SplashMvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Alaeddine Khoudi .
 */

public class StartActivity extends BaseActivity implements StartMvpView {


    @Inject
    StartMvpPresenter<StartMvpView> presenter;



    public static Intent getStartIntent(Context context) {
        return new Intent(context, StartActivity.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(StartActivity.this);

        setUp();
    }


    @OnClick(R.id.start)
    void onStartClicked() {
        openSelectActivity();
    }


    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openSelectActivity() {
        startActivity(SelectActivity.getStartIntent(StartActivity.this));
    }
}
