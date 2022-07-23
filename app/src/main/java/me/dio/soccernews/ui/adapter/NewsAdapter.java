package me.dio.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.dio.soccernews.R;
import me.dio.soccernews.databinding.NewsItemBinding;
import me.dio.soccernews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private final List<News> news;
    private final FavoriteListener favoriteListener;

    public NewsAdapter(List<News> news, FavoriteListener favoriteListener) {

        this.news=news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        News news = this.news.get(position);
        holder.binding.tvNewsTitle.setText(news.newsTitle);
        holder.binding.tvNews.setText(news.news);
        Picasso.get().load(news.image)
                .fit()
                .into(holder.binding.ivThumbnail);

        holder.binding.bt_OpenLink.setOnClickListener(view->{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.link));
            context.startActivity(i);
        });
        //Implemerntar funcionalidade Compartilhar.
        holder.binding.iv_Share.setOnClickListener(view ->{
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, news.link);
            context.startActivity(Intent.createChooser(i, "Share"));

        });
        //Implementar funcionalidade Favoritar.
        holder.binding.iv_Favorite.setOnClickListener(view ->{
            news.favorite = ! news.favorite;
            this.favoriteListener.onFavorite(news);
            notifyItemChanged(position);
        });
        int favoriteColor = news.favorite ? R.color.favorite_active : R.color.favorite_inactive;
        holder.binding.iv_Favorite.setColorFilter(context.getResources().getColor(favoriteColor));
    }


    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        private NewsItemBinding binding;

        public viewHolder(NewsItemBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Object binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class News {
        public int image;
        public Object newsTitle;
        public Object news;
        public String link;
        public boolean favorite;
    }

    public interface FavoriteListener {
        void onFavorite(NewsAdapter.News news);
    }
}
