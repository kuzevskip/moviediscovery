package com.pavlekuzevski.moviediscovery.data.remote.retrofit;

import com.pavlekuzevski.moviediscovery.data.model.MoviesResponse;
import com.pavlekuzevski.moviediscovery.data.remote.ApiEndpoints;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET(ApiEndpoints.DISCOVER_MOVIE)
    Single<MoviesResponse> getMovies(@Query("api_key") String apiKey, @Query("language") String languageCode,
                                     @Query("sort_by") String sortBy, @Query("include_adult") Boolean includeAdult,
                                     @Query("include_video") Boolean includeVideo, @Query("page") Integer page,
                                     @Query("release_date.gte") String beginDate, @Query("release_date.lte") String endDate);
}
