package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData <List<News>> News;

    public NewsViewModel() {
        this.News = new MutableLiveData<>();
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviária tem Desfalque Importante.",""));
        news.add(new News("Ferroviária joga Sábado",""));
        news.add(new News("Copa do Mundo Feminina está terminando.",""));
    }

    public LiveData<List<News>> getNews() {
        return News;
    }
}