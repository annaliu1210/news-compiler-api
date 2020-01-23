package com.api.newscompilerapi.HtmlParser;

import com.api.newscompilerapi.models.Article;

import java.io.IOException;
import java.util.List;

public abstract class SearchPageParser {

    protected String searchUrl;

    public SearchPageParser(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public abstract List<Article> parseForArticles(String query) throws IOException;
}