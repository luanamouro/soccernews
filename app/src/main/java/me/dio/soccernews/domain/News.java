package me.dio.soccernews.domain;

public class News {
    private string NewsTitle;
    private string News;

    public News(String newsTitle, String news) {
        NewsTitle = newsTitle;
        News = news;
    }

    public string getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(string newsTitle) {
        NewsTitle = newsTitle;
    }

    public string getNews() {
        return News;
    }

    public void setNews(string news) {
        News = news;
    }
}
