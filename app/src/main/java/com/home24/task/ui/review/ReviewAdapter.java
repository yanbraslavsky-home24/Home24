package com.home24.task.ui.review;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.home24.task.R;
import com.home24.task.data.model.Article;
import com.home24.task.di.PerActivity;
import com.home24.task.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alaeddine Khoudi .
 */

@PerActivity
public class ReviewAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<Article> list;

    public ReviewAdapter(List<Article> list) {
        this.list = list;
    }

    private ReviewActivity.LayoutManagerType mLayoutManagerType;


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutManagerType == ReviewActivity.LayoutManagerType.GRID_LAYOUT_MANAGER)
            return new GridViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_grid, parent, false)
            );
        else
            return new LinearViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_linear, parent, false)
            );

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    public void addItems(List<Article> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    void updateListItems(List<Article> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    public class LinearViewHolder extends BaseViewHolder {

        @BindView(R.id.picture)
        ImageView picture;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.like)
        TextView like;

        public LinearViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            title.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            Article article = (Article) list.get(position);

            if (article != null) {

                if (article.getMedia().get(0).getUri() != null)
                    Glide.with(itemView.getContext())
                            .load(article.getMedia().get(0).getUri())
                            .asBitmap()
                            .placeholder(R.drawable.progress_animation)
                            .into(picture);

                if (article.getTitle() != null)
                    title.setText(article.getTitle());


                if (article.isLiked) {
                    like.setText(itemView.getContext().getString(R.string.awesome_thumb_up));
                } else {
                    like.setText(itemView.getContext().getString(R.string.awesome_thumb_down));
                }

            }
        }
    }


    public class GridViewHolder extends BaseViewHolder {

        @BindView(R.id.picture)
        ImageView picture;

        @BindView(R.id.like)
        TextView like;



        public GridViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            Article article = (Article) list.get(position);

            if (article != null) {

                if (article.getMedia().get(0).getUri() != null)
                    Glide.with(itemView.getContext())
                            .load(article.getMedia().get(0).getUri())
                            .asBitmap()
                            .placeholder(R.drawable.progress_animation)
                            .into(picture);

                if (article.isLiked) {
                    like.setText(itemView.getContext().getString(R.string.awesome_thumb_up));
                } else {
                    like.setText(itemView.getContext().getString(R.string.awesome_thumb_down));
                }

            }
        }
    }

    public ReviewActivity.LayoutManagerType getmLayoutManagerType() {
        return mLayoutManagerType;
    }

    public void setmLayoutManagerType(ReviewActivity.LayoutManagerType mLayoutManagerType) {
        this.mLayoutManagerType = mLayoutManagerType;
    }
}
