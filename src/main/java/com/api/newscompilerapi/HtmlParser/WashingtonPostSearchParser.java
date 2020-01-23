package com.api.newscompilerapi.HtmlParser;

import com.api.newscompilerapi.models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class WashingtonPostSearchParser extends SearchPageParser {

    public WashingtonPostSearchParser() { super("https://www.washingtonpost.com/newssearch/?query="); }

    @Override
    public List<Article> parseForArticles(String query) throws IOException {
        Document doc = Jsoup.connect(searchUrl + query).get();
        Element searchResults = doc.getElementById("/app/views/main.html");
//                .getElementById("pb-root");
//                .getElementById("article-standard-content");
//                .getElementById("main-content");
//        Element searchResults = doc.body().getElementById("pb-root");
//                .getElementById("article-standard-content");
//                .getElementById("main-content");
//                .getElementsByClass("ng-scope").first();
//                .getElementsByClass("pb-search-wrapper").first();
        System.out.println(searchResults);
//        System.out.println(doc.toString());
        return null;
    }

    public static void main(String[] args) throws Exception {
        WashingtonPostSearchParser parser = new WashingtonPostSearchParser();
        parser.parseForArticles("penguins");
    }
}
