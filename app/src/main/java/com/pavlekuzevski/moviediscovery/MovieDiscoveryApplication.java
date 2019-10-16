package com.pavlekuzevski.moviediscovery;

import android.app.Activity;
import android.app.Application;
import com.pavlekuzevski.moviediscovery.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MovieDiscoveryApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
