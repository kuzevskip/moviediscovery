package com.pavlekuzevski.moviediscovery.di.builder;

import com.pavlekuzevski.moviediscovery.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
