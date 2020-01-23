package com.api.newscompilerapi.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class NewsController {

    @RequestMapping("/search")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/anna")
    public String f2() {
        return "Greetings from Spring Anna Boot!";
    }
}