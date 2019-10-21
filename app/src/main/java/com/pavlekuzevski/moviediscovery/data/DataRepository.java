package com.pavlekuzevski.moviediscovery.data;

import com.pavlekuzevski.moviediscovery.data.model.MoviesResponse;


import io.reactivex.Single;

public interface DataRepository {
    Single<MoviesResponse> getMovies(String languageCode,
                                     String sortBy, Boolean includeAdult,
                                     Boolean includeVideo, Integer page,
                                     String beginDate, String endDate);
}
