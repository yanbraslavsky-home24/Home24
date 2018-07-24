/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.home24.task.ui.review;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.home24.task.R;
import com.home24.task.data.model.Article;
import com.home24.task.ui.base.BaseActivity;
import com.home24.task.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alaeddine Khoudi .
 */

public class ReviewActivity extends BaseActivity implements ReviewMvpView {

    public static final String KEY_PARCELABLE_ARTICLES = "KEY_PARCELABLE_ARTICLES";

    @Inject
    ReviewMvpPresenter<ReviewMvpView> mPresenter;

    @Inject
    ReviewAdapter reviewAdapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    //@Inject
    GridLayoutManager gridLayoutManager;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @BindView(R.id.list)
    RecyclerView list;

    private static final int SPAN_COUNT = 2;

    public enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    List<Article> articleList;


    public static Intent getStartIntent(Context context, ArrayList<Article> list) {
        Intent intent = new Intent(context, ReviewActivity.class);
        intent.putParcelableArrayListExtra(KEY_PARCELABLE_ARTICLES, list);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {

        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.review));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        articleList = getIntent().getParcelableArrayListExtra(KEY_PARCELABLE_ARTICLES);


        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(linearLayoutManager);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(reviewAdapter);
        reviewAdapter.addItems(articleList);


    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_review, menu);
        menu.findItem(R.id.action_list).setIcon(CommonUtils.getTextDrawable(ReviewActivity.this, R.string.awesome_list));
        menu.findItem(R.id.action_grid).setIcon(CommonUtils.getTextDrawable(ReviewActivity.this, R.string.awesome_grid));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_grid:
                if (list.getLayoutManager() == gridLayoutManager) return true;

                reviewAdapter.setmLayoutManagerType(LayoutManagerType.GRID_LAYOUT_MANAGER);
                gridLayoutManager = new GridLayoutManager(ReviewActivity.this, SPAN_COUNT);
                list.setAdapter(null);
                list.setLayoutManager(gridLayoutManager);
                list.setAdapter(reviewAdapter);
                return true;


            case R.id.action_list:
                if (list.getLayoutManager() == linearLayoutManager) return true;

                reviewAdapter.setmLayoutManagerType(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
                list.setAdapter(null);
                list.setLayoutManager(linearLayoutManager);
                list.setAdapter(reviewAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
