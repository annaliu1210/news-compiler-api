package com.api.newscompilerapi.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class NewsController {

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/anna", method=RequestMethod.GET)
    public String f2() {
        return "Greetings from Spring Anna Boot!";
    }
}