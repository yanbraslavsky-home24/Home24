package com.home24.task.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Article implements Parcelable {
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("media")
    @Expose
    private ArrayList<Media> media = null;


    public boolean isLiked;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(sku);
        parcel.writeString(title);
        parcel.writeValue(isLiked);
        parcel.writeList(media);
    }

    public static Parcelable.Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel parcel) {
            Article article = new Article();

            article.sku = parcel.readString();
            article.title = parcel.readString();
            article.isLiked = (Boolean) parcel.readValue(null);
            article.media = parcel.readArrayList(Media.class.getClassLoader());

            return article;
        }

        @Override
        public Article[] newArray(int i) {
            return new Article[i];
        }
    };
}
