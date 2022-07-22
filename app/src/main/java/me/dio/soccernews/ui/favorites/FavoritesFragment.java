package me.dio.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import me.dio.soccernews.MainActivity;
import me.dio.soccernews.databinding.FragmentFavoritesBinding;
import me.dio.soccernews.domain.News;
import me.dio.soccernews.ui.adapter.NewsAdapter;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel favoritesViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();

        loadFavoriteNews(activity);

        View root = binding.getRoot();

        final TextView textView = binding.textFavorites;
        favoritesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return binding.getRoot();
    }

    private void loadFavoriteNews(MainActivity activity) {
        if (activity != null){
            List<News> favoriteNews = activity.getDb().news_Dao().loadFavoriteNews();
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvNews.setAdapter(new NewsAdapter(news, upDatedNews ->{
                activity.getDb().news_Dao().save(upDatedNews);
                loadFavoriteNews();
        }));
    }

    ;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

    private void loadFavoriteNews() {
    }