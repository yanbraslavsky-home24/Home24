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

package com.home24.task.ui.select;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.home24.task.R;
import com.home24.task.data.model.Article;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeView;

/**
 * Created by Alaeddine Khoudi .
 */

@NonReusable
@Layout(R.layout.item_article_card)
public class ArticleCard {


    @View(R.id.title)
    private TextView title;

    @View(R.id.picture)
    private ImageView picture;

    @SwipeView
    public android.view.View view;

    public Article article;

    public ArticleCard(Article article) {
        this.article = article;
    }

    @Resolve
    private void onResolved() {

        if (article != null) {
            if (article.getMedia().get(0).getUri() != null)
                Glide.with(view.getContext())
                        .load(article.getMedia().get(0).getUri())
                        .asBitmap()
                        .placeholder(R.drawable.progress_animation)
                        .into(picture);

            if (article.getTitle() != null)
                title.setText(article.getTitle());

        }
    }


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


}
