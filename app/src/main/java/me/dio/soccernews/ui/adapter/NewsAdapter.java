package me.dio.soccernews.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import me.dio.soccernews.databinding.NewsItemBinding;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
    }
}
