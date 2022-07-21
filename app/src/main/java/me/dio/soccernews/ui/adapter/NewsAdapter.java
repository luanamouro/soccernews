package me.dio.soccernews.ui.adapter;

import android.icu.text.Transliterator;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.tool.Binding;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
        Picasso.get().load(news.getImage())
                .fit()
                .into(holder.binding.im_soccerNews);
        holder.binding.bt_OpenLink.setOnClickListener(view->{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.getLink()));
            holder.itemView.getContext().startActivity(i);
        });
        //Implemerntar funcionalidade Compartilhar.
        holder.binding.iv_share.setOnClickListener(view ->{
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,news.getLink());
            holder.itemView.getContext().startActivity(Intent.createChooser(i, "Share"));

        });
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        private NewsItemBinding binding;
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
        public Object binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(NewsItemBinding binding) {
            super(binding);
        }
    }
}
