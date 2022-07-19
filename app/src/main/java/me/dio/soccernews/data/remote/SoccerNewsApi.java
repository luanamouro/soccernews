package me.dio.soccernews.data.remote;

import java.util.List;

import me.dio.soccernews.domain.News;

public interface SoccerNewsApi {
    @GET("news.json")
    Call<List<News>> groupList();
}
