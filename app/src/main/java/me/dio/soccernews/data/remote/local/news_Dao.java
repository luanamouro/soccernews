package me.dio.soccernews.data.remote.local;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import me.dio.soccernews.domain.News;

public interface news_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save (News news);
    @Query("SELECT * FROM news WHERE favorite = 1")
    List<News> loadFavoriteNews();
}
