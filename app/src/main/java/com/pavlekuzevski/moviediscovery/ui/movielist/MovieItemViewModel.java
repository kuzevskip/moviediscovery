package com.pavlekuzevski.moviediscovery.ui.movielist;

import com.pavlekuzevski.moviediscovery.data.model.Movie;

import androidx.databinding.ObservableField;

public class MovieItemViewModel {

    public final ObservableField<String> title;

    public final ObservableField<String> releaseDate;

    public final ObservableField<String> description;

    MovieItemViewModel(Movie movie){
        title = new ObservableField<>(movie.getTitle());
        releaseDate = new ObservableField<>(movie.getReleaseDate());
        description = new ObservableField<>(movie.getOverview());
    }
}
