package me.dio.soccernews.ui.adapter;

import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.tool.Binding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.dio.soccernews.databinding.NewsItemBinding;
import me.dio.soccernews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List<News> news;

    public NewsAdapter(List<News> news){
        this.news=news;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       News news = this.news.get(position);
        holder.binding.tv_NewsTitle.setText(news.getNewsTitle());
        holder.binding.tv_News.setText(news.getNews());

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding.Binding;

        public void ViewHolder (NewsItemBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(NewsItemBinding binding) {
            super(binding);
        }
    }
}
