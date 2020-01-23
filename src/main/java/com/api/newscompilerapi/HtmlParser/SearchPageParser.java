package com.api.newscompilerapi.HtmlParser;

import java.util.List;

public abstract class SearchPageParser {

    protected String searchUrl;

    public SearchPageParser(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public abstract List<String> parseForArticles(String query);
}