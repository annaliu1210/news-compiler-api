package com.api.newscompilerapi.HtmlParser;

import com.api.newscompilerapi.models.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NYPostSearchParser extends SearchPageParser {

    public NYPostSearchParser() {
        super("https://nypost.com/search/");
    }

    @Override
    public List<Article> parseForArticles(String query) throws IOException {
        Document doc = Jsoup.connect(searchUrl + query).get();
        List<Article> articles = new ArrayList<>();
        Elements articleElements = doc.getElementsByClass("article-loop").select("li");
        for (Element articleElement : articleElements) {
            Element html = articleElement.getElementsByClass("entry-header").first()
                    .getElementsByClass("entry-heading").first()
                    .child(0);
            String url = html.attr("href");
            String title = html.text();
            Article newArticle = new Article(url, title, null);
            articles.add(newArticle);
        }
        return articles;
    }

    public static void main(String[] args) throws Exception {
        NYPostSearchParser parser = new NYPostSearchParser();
        parser.parseForArticles("penguins");
    }
}
