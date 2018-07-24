package com.home24.task.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.home24.task.R;
import com.home24.task.ui.base.BaseActivity;
import com.home24.task.ui.start.StartActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alaeddine Khoudi .
 */

public class SplashActivity extends BaseActivity implements SplashMvpView {


    @Inject
    SplashMvpPresenter<SplashMvpView> presenter;

    @BindView(R.id.lottie_load)
    LottieAnimationView loadLAV;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(SplashActivity.this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        loadLAV.clearAnimation();
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        loadLAV.playAnimation();
    }


    @Override
    public void openStartActivity() {
       startActivity(StartActivity.getStartIntent(SplashActivity.this));
        finish();
    }
}
