package com.pavlekuzevski.moviediscovery.di.component;

import android.app.Application;

import com.pavlekuzevski.moviediscovery.MovieDiscoveryApplication;
import com.pavlekuzevski.moviediscovery.di.builder.ActivityBuilder;
import com.pavlekuzevski.moviediscovery.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class, ActivityBuilder.class})
public interface ApplicationComponent {

    void inject(MovieDiscoveryApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
