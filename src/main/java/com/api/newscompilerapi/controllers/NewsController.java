package com.api.newscompilerapi.controllers;

import com.api.newscompilerapi.HtmlParser.NYPostSearchParser;
import com.api.newscompilerapi.HtmlParser.NYTimesSearchParser;
import com.api.newscompilerapi.models.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String getArticles(@RequestParam("query") String query) throws IOException {
        JSONArray articlesJSON = new JSONArray();

        NYTimesSearchParser nYTimesParser = new NYTimesSearchParser();
        List<Article> nYTimesArticles = nYTimesParser.parseForArticles(query);
        for (Article article : nYTimesArticles) {
            JSONObject articleJSON = new JSONObject();
            articleJSON.put("url", article.getUrl());
            articleJSON.put("title", article.getTitle());
            articlesJSON.put(articleJSON);
        }

        NYPostSearchParser nYPostParser = new NYPostSearchParser();
        List<Article> nYPostArticles = nYPostParser.parseForArticles(query);
        for (Article article : nYPostArticles) {
            JSONObject articleJSON = new JSONObject();
            articleJSON.put("url", article.getUrl());
            articleJSON.put("title", article.getTitle());
            articlesJSON.put(articleJSON);
        }
        
        return articlesJSON.toString();
    }

    @RequestMapping(value="/anna", method=RequestMethod.GET)
    public String f2() {
        return "Greetings from Spring Anna Boot!";
    }
}