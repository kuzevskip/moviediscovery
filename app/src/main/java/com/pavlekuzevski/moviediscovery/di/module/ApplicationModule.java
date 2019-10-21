package com.pavlekuzevski.moviediscovery.di.module;

import android.app.Application;
import android.content.Context;

import com.pavlekuzevski.moviediscovery.BuildConfig;
import com.pavlekuzevski.moviediscovery.data.ApplicationDataRepository;
import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.data.remote.retrofit.RetrofitService;
import com.pavlekuzevski.moviediscovery.utils.rx.ApplicationSchedulerProvider;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataRepository provideDataRepository(ApplicationDataRepository dataManager) { return dataManager;}

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static RetrofitService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new ApplicationSchedulerProvider();
    }
}
