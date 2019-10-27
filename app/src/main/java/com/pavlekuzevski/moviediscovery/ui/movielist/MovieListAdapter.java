package com.pavlekuzevski.moviediscovery.ui.movielist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pavlekuzevski.moviediscovery.data.model.Movie;
import com.pavlekuzevski.moviediscovery.databinding.ItemMovieViewBinding;
import com.pavlekuzevski.moviediscovery.ui.base.BaseViewHolder;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Movie> movieItems;

    public MovieListAdapter(List<Movie> movieItems) {
        this.movieItems = movieItems;
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void addItems(List<Movie> movieList) {
        movieItems.addAll(movieList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        movieItems.clear();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMovieViewBinding itemMovieViewBinding = ItemMovieViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new MovieViewHolder(itemMovieViewBinding);
    }

    public class MovieViewHolder extends BaseViewHolder {

        private ItemMovieViewBinding binding;

        private MovieItemViewModel viewModel;

        public MovieViewHolder(ItemMovieViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            final Movie movie = movieItems.get(position);
            viewModel = new MovieItemViewModel(movie);
            binding.setViewModel(viewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            binding.executePendingBindings();
        }
    }
}
