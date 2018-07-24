package com.home24.task.ui.select;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.home24.task.R;
import com.home24.task.data.model.Article;
import com.home24.task.ui.base.BaseActivity;
import com.home24.task.ui.review.ReviewActivity;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.home24.task.utils.AppConstants.LIMIT;

/**
 * Created by Alaeddine Khoudi .
 */

public class SelectActivity extends BaseActivity
        implements SelectMvpView {

    @Inject
    SelectMvpPresenter<SelectMvpView> presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.mainView)
    FrameLayout mainView;

    @BindView(R.id.counter)
    TextView counter;


    @BindView(R.id.secondView)
    LinearLayout secondView;


    @BindView(R.id.like)
    TextView like;

    @BindView(R.id.dislike)
    TextView dislike;

    @BindView(R.id.swipeView)
    SwipePlaceHolderView swipeView;




    ArrayList<Article> articleList;

    int ind = 0, liked =0;


    public static Intent getStartIntent(Context context) {
        return new Intent(context, SelectActivity.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(this);

        setUp();
    }


    @Override
    protected void setUp() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.article_selection));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        updateLikesCountUi();
        setupSwipView();
        presenter.fetchArticleList();
    }



    @OnClick(R.id.like)
    public void onLikeClick() {
        swipeToNext(true);
    }

    @OnClick(R.id.dislike)
    public void onDislikeClick() {
        swipeToNext(false);
    }

    @OnClick(R.id.review)
    public void onReviewClick() {
        startActivity(ReviewActivity.getStartIntent(SelectActivity.this,articleList));
    }


    private void setupSwipView() {

        swipeView.getBuilder()
                .setDisplayViewCount(3)
                .setIsUndoEnabled(false)
                .setWidthSwipeDistFactor(4)
                .setHeightSwipeDistFactor(6)
                .setSwipeDecor(new SwipeDecor()
                        .setSwipeAnimTime(500)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.view_swipe_like)
                        .setSwipeOutMsgLayoutId(R.layout.view_swipe_dislike));

        swipeView.disableTouchSwipe();

        swipeView.addItemRemoveListener(new ItemRemovedListener() {
            @Override
            public void onItemRemoved(int count) {
                unlock();
                ind++;
                if (count == 0) {
                    showSecondView();
                }
            }
        });
    }



    @Override
    public void fetchedArticles(ArrayList<Article> articleList) {
        this.articleList=articleList;
        for (Article article : articleList) {
            if (article != null) {
                swipeView.addView(new ArticleCard(article));
            }
        }
    }

    @Override
    public void showMainView() {
        mainView.setVisibility(View.VISIBLE);
        secondView.setVisibility(View.GONE);
    }

    public void showSecondView() {
        mainView.setVisibility(View.GONE);
        secondView.setVisibility(View.VISIBLE);
    }


    private void updateLikesCountUi() {
        counter.setText(String.format("%d/%d",liked,LIMIT));
    }

    private void swipeToNext(Boolean isLiked) {
        lock();
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeView.doSwipe(isLiked);
                articleList.get(ind).setLiked(isLiked);
                if(isLiked){
                    liked++;
                    updateLikesCountUi();
                }
            }
        }, 500);

    }


    private void unlock() {
        like.setClickable(true);
        dislike.setClickable(true);
    }

    private void lock() {
        like.setClickable(false);
        dislike.setClickable(false);
    }


    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
