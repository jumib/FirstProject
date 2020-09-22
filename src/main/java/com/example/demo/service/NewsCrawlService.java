package com.example.demo.service;

import com.example.demo.entity.ClickedNews;
import com.example.demo.entity.HomeNews;
import com.example.demo.entity.News;
import com.example.demo.repository.ClickedNewsRepository;
import com.example.demo.repository.HomeNewsRepository;
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

    @Autowired
    HomeNewsRepository homeNewsRepository;

    @Autowired
    ClickedNewsRepository clickedNewsRepository;

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

    public List<HomeNews> homeNewsFindAll() {
        log.info("homeNewsFindAll()");

        return homeNewsRepository.findAll();
    }

    public void crawlingHome() {
        log.info("crawlingHome()");

        homeNewsRepository.deleteAll();
        document = connectUrl("https://www.ohou.se/projects?writer=self");
        // document = connectUrl("https://www.naver.com/");

        Elements total = document.select("strong.tit_thumb>a.link_txt");
        Elements image = document.select("div.item_issue>a.link_thumb>img.thumb_g");

        HomeNews homeNews = null;

        for (int i = 0; i < total.size(); i++) {
            homeNews = new HomeNews();
            homeNews.setHomeNewsNo(String.valueOf(i + 1));
            homeNews.setTitle(total.get(i).text());
            homeNews.setAddress(total.get(i).attr("href"));
            homeNews.setImage(image.get(i).attr("src"));
            homeNewsRepository.save(homeNews);
        }
    }

    public void mainCrawler() {
        log.info("mainCrawler(): ");

        document = connectUrl("https://www.ohou.se/projects?writer=self");
        // document = connectUrl("https://www.naver.com/");
        newsRepository.deleteAll();

        daumNews(document.select("div.virtualized-list.row>div.col-12.col-md-4>article.project-feed__item"));
        // daumNews(document.select("div.theme_cont>div.group_theme>div.list_theme_wrap>ul.list_theme>li.theme_item>a.theme_info>strong"));
        // div#themecast.sc_themecast.id_livinghome> 추가하면 크롤링 안됨
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

    public ClickedNews crawlingOne(String newsNo) {
        log.info("crawlingOne(): " + newsNo);

        News news = newsRepository.findByNewsNo(newsNo);

        ClickedNews clickedNews = new ClickedNews();

        clickedNews.setTitle(news.getTitle());
        clickedNews.setAddress(news.getAddress());
        clickedNews.setClickedNewsNo(String.valueOf(clickedNewsRepository.findAll().size() + 1));

        document = connectUrl(clickedNews.getAddress());

        clickedNews.setDate(document.select("span.num_date").text());
        clickedNews.setContents(document.select("div.article_view>section>:not(figure)").text());

        clickedNewsRepository.save(clickedNews);

        return clickedNews;
    }
}