package com.api.newscompilerapi.HtmlParser;

import com.api.newscompilerapi.models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NYTimesSearchParser extends SearchPageParser {

    public NYTimesSearchParser() {
        super("https://www.nytimes.com/search?query=");
    }

    @Override
    public List<Article> parseForArticles(String query) throws IOException {
        Document doc = Jsoup.connect(searchUrl + query).get();
        Element articleListElement = doc.getElementById("site-content")
                .getElementsByClass("css-1wa7u5r").first()
                .child(1)
                .getElementsByClass("css-46b038").first()
                .child(0);
        Elements articleElements = articleListElement.getElementsByClass("css-1l4w6pd");
        List<Article> articles = new ArrayList<>();
        for (Element articleElement : articleElements) {
            Element urlElement = articleElement.getElementsByTag("div").first()
                    .getElementsByClass("css-1i8vfl5").first()
                    .getElementsByClass("css-e1lvw9").first()
                    .getElementsByTag("a").first();
            String url = "https://www.nytimes.com" + urlElement.attr("href");
            Element titleElement = urlElement.getElementsByTag("h4").first();
            String title = titleElement.text();
//            Element timeElement = articleElement.getElementsByTag("div").first()
//                    .getElementsByTag("time").first();
            Article article = new Article(url, title, null);
            articles.add(article);
        }
        return articles;
    }

    public static void main(String[] args) throws Exception {
        NYTimesSearchParser parser = new NYTimesSearchParser();
        parser.parseForArticles("penguins");
    }
}
