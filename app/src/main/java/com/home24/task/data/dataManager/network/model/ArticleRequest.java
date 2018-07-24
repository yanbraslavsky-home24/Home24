package com.home24.task.data.dataManager.network.model;

/**
 * Created by Alaeddine Khoudi.
 */

public class ArticleRequest {


    private String Language;
    private int limit;

    public ArticleRequest(String language, int limit) {
        Language = language;
        this.limit = limit;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
