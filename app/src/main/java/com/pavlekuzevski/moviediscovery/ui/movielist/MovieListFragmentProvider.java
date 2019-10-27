package com.pavlekuzevski.moviediscovery.ui.movielist;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieListFragmentProvider {

    @ContributesAndroidInjector(modules = MovieListModule.class)
    abstract MovieListFragment provideMovieListFragmentFactory();
}
