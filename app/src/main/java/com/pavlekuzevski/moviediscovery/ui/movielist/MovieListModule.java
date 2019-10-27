package com.pavlekuzevski.moviediscovery.ui.movielist;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

@Module
public class MovieListModule {

    @Provides
    MovieListAdapter provideMovieListAdapter() {
        return new MovieListAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(MovieListFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
