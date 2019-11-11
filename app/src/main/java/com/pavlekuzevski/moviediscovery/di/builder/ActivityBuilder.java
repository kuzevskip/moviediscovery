package com.pavlekuzevski.moviediscovery.di.builder;

import com.pavlekuzevski.moviediscovery.ui.main.MainActivity;
import com.pavlekuzevski.moviediscovery.ui.movielist.MovieListFragmentProvider;
import com.pavlekuzevski.moviediscovery.ui.selectdates.SelectDatesFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MovieListFragmentProvider.class, SelectDatesFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
