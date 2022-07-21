package me.dio.soccernews.data.remote.local;

import androidx.room.Query;

import java.util.List;

import me.dio.soccernews.domain.News;

public interface news_Dao {
    @Query("SELECT * FROM news WHERE favorite = favorite")
    List<News> loadAllByIds(boolean favorite);
}
