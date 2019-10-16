package com.pavlekuzevski.moviediscovery;

import android.app.Application;
import com.pavlekuzevski.moviediscovery.di.component.DaggerApplicationComponent;

public class MovieDiscoveryApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
