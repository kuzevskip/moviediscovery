package com.pavlekuzevski.moviediscovery.ui.selectdates;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SelectDatesFragmentProvider {

    @ContributesAndroidInjector()
    abstract SelectDatesFragment provideSelectDatesFragmenttFactory();
}
