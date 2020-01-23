package com.api.newscompilerapi.HtmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class NYTimesSearchParser extends SearchPageParser {

    public NYTimesSearchParser() {
        super("https://www.nytimes.com/search?query=");
    }

    @Override
    public List<String> parseForArticles(String query) throws IOException {
        Document doc = Jsoup.connect(searchUrl + query).get();
        Element articleList = doc.getElementById("site-content")
                .getElementsByClass("css-1wa7u5r").first()
                .child(1)
                .getElementsByClass("css-46b038").first()
                .child(0);
        System.out.println(articleList.toString());
        Elements articles = articleList.getElementsByClass("css-1l4w6pd");
        System.out.println("articles-------------");
        for (Element article : articles) {
            System.out.println(article.toString());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        NYTimesSearchParser parser = new NYTimesSearchParser();
        parser.parseForArticles("penguins");
    }
}
