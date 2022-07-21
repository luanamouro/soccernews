package me.dio.soccernews.domain;

import android.net.Uri;

@Entity
public class News {
    @PrimaryKey
    public int id;
    public string newsTitle;
    public string news;
    public string image;
    public string link;
    public boolean favorite;
    public Object NewsTitle;
}
