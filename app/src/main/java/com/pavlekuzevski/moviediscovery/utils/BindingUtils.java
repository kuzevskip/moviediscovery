package com.pavlekuzevski.moviediscovery.utils;

import com.pavlekuzevski.moviediscovery.data.model.Movie;
import com.pavlekuzevski.moviediscovery.ui.movielist.MovieListAdapter;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BindingUtils {

    @BindingAdapter({"adapter_items"})
    public static void addMovieItems(RecyclerView recyclerView, List<Movie> movies) {
        MovieListAdapter adapter = (MovieListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(movies);
        }
    }
}
