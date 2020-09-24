package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.service.NewsCrawlService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CrawlController {
    @Autowired
    NewsCrawlService newsCrawler;

    @GetMapping("")
    public List<News> crawling() {
        log.info("crawling(): ");

        newsCrawler.mainCrawler();
        return newsCrawler.newsFindAll();
    }
}