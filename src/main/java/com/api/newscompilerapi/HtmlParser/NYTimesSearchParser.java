package com.api.newscompilerapi.HtmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class NYTimesSearchParser extends SearchPageParser {

    public NYTimesSearchParser() {
        super("https://www.nytimes.com/search?query=");
    }

    @Override
    public List<String> parseForArticles(String query) throws IOException {
        Document doc = Jsoup.connect(searchUrl + query).get();
        System.out.println(doc.toString());
        return null;
    }

    public static void main(String[] args) throws Exception {
        NYTimesSearchParser parser = new NYTimesSearchParser();
        parser.parseForArticles("penguins");
    }
}
