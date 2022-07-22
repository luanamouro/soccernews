package me.dio.soccernews.ui.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import java.util.Objects;

import me.dio.soccernews.databinding.FragmentNewsBinding;
import me.dio.soccernews.ui.adapter.NewsAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "soccer's_news").build();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel newsViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        newsViewModel.getNews().observe(getViewLifecycleOwner(), news -> {
            binding.rvNews.setAdapter(new NewsAdapter(news,upDatedNews ->{

                AsyncTask.execute(() ->{db.news_Dao().insert(upDatedNews);
                    }));

        });
        return root;
    }

    private void build() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}