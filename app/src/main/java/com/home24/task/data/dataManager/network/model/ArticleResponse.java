package com.home24.task.data.dataManager.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.home24.task.data.model.Embedded;

/**
 * Created by Alaeddine Khoudi.
 */
public class ArticleResponse {



    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

}
