package com.api.newscompilerapi.HtmlParser;

import java.util.List;

public class NYTimesSearchParser extends SearchPageParser {

    public NYTimesSearchParser() {
        super("https://www.nytimes.com/search?query=");
    }

    @Override
    public List<String> parseForArticles() {
        return null;
    }
}
