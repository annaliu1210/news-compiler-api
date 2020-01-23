package com.api.newscompilerapi.models;

import java.util.Date;

public class Article {

    private String url;
    private String title;
    private Date date;

    public Article(String url, String title, Date date) {
        this.url = url;
        this.title = title;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle(){
        return title;
    }

    public Date getDate(){
        return date;
    }
}
