package com.home24.task.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.home24.task.data.model.Article;
import com.home24.task.di.ActivityContext;
import com.home24.task.di.PerActivity;
import com.home24.task.ui.review.ReviewAdapter;
import com.home24.task.ui.review.ReviewMvpPresenter;
import com.home24.task.ui.review.ReviewMvpView;
import com.home24.task.ui.review.ReviewPresenter;
import com.home24.task.ui.select.SelectMvpPresenter;
import com.home24.task.ui.select.SelectMvpView;
import com.home24.task.ui.select.SelectPresenter;
import com.home24.task.ui.splash.SplashMvpPresenter;
import com.home24.task.ui.splash.SplashMvpView;
import com.home24.task.ui.splash.SplashPresenter;
import com.home24.task.ui.start.StartMvpPresenter;
import com.home24.task.ui.start.StartMvpView;
import com.home24.task.ui.start.StartPresenter;
import com.home24.task.utils.rx.AppSchedulerProvider;
import com.home24.task.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Alaeddine Khoudi .
 */

@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideScheduleProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    StartMvpPresenter<StartMvpView> provideStartPresenter(StartPresenter<StartMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SelectMvpPresenter<SelectMvpView> provideSelectPresenter(SelectPresenter<SelectMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    ReviewMvpPresenter<ReviewMvpView> provideReviewPresenter(ReviewPresenter<ReviewMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ReviewAdapter providesReviewAdapter() {
        return new ReviewAdapter(new ArrayList<Article>());
    }


/*
    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> providesMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    BlogMvpPresenter<BlogMvpView> providesBlogPresenter(BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    OpenSourceMvpPresenter<OpenSourceMvpView> providesOpenSourcePresenter(OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    BlogDetailsMvpPresenter<BlogDetailsMvpView> providesBlogDetailsPresenter(BlogDetailsPresenter<BlogDetailsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    OSDetailMvpPresenter<OSDetailMvpView> providesOSDetailPresenter(OSDetailPresenter<OSDetailMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SelectMvpPresenter<SelectMvpView> providesSelectPresenter(SelectPresenter<SelectMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainPagerAdapter providesMainPagerAdapter(AppCompatActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    @PerActivity
    BlogAdapter providesBlogAdapter() {
        return new BlogAdapter(new ArrayList<Blog>());
    }

    @Provides
    @PerActivity
    OpenSourceAdapter providesOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSource>());
    }

    @Provides
    @PerActivity
    SelectAdapter providesSelectAdapter() {
        return new SelectAdapter(new ArrayList<Object>());
    }*/
}
