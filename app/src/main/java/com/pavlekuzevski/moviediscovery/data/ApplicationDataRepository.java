package com.pavlekuzevski.moviediscovery.data;

import com.pavlekuzevski.moviediscovery.BuildConfig;
import com.pavlekuzevski.moviediscovery.data.model.MoviesResponse;
import com.pavlekuzevski.moviediscovery.data.remote.retrofit.RetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApplicationDataRepository implements DataRepository {

    private RetrofitService retrofitService;

    @Inject
    ApplicationDataRepository(RetrofitService retrofitService)
    {
        this.retrofitService = retrofitService;
    }

    @Override
    public Single<MoviesResponse> getMovies(String languageCode, String sortBy, Boolean includeAdult, Boolean includeVideo, Integer page, String beginDate, String endDate) {
        return retrofitService.getMovies(BuildConfig.API_KEY, languageCode, sortBy, includeAdult, includeVideo, page, beginDate, endDate);
    }
}
