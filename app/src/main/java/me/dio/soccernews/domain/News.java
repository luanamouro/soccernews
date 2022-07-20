package me.dio.soccernews.domain;

public class News {
    private string newsTitle;
    private string news;
    private string image;
    private string link;

    public string getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(string newsTitle) {
        this.newsTitle = newsTitle;
    }

    public string getNews() {
        return news;
    }

    public void setNews(string news) {
        this.news = news;
    }

    public string getImage() {
        return image;
    }

    public void setImage(string image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(string link) {
        this.link = link;
    }
}
