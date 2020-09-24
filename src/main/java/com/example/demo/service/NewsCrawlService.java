package com.example.demo.service;

import com.example.demo.entity.News;
import com.example.demo.repository.NewsRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Log
public class NewsCrawlService {
    @Autowired
    NewsRepository newsRepository;

    private Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<News> newsFindAll() {
        log.info("newsFindAll()");

        return newsRepository.findAll();
    }

    public void mainCrawler() {
        log.info("mainCrawler(): ");

        document = connectUrl("https://www.ohou.se/projects?writer=self");
        newsRepository.deleteAll();

        daumNews(document.select("div.virtualized-list.row>div.col-12.col-md-4>article.project-feed__item"));
    }

    public void daumNews(Elements elements) {
        log.info("daumNews(): elements - " + elements);

        News news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new News();

            news.setNewsNo(String.valueOf(newsRepository.findAll().size() + 1));
            news.setAddress("https://www.ohou.se" + elements.get(i).select("a.project-feed__item__link").attr("href"));
            news.setTitle(elements.get(i).select("h1.project-feed__item__title").text());

            newsRepository.save(news);
        }
    }
}