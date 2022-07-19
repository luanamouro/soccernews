package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData <List<News>> news = new MutableLiveData<>();

    public NewsViewModel() {

    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}