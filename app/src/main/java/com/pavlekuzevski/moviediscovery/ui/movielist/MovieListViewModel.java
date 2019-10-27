package com.pavlekuzevski.moviediscovery.ui.movielist;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.data.model.Movie;
import com.pavlekuzevski.moviediscovery.ui.base.BaseViewModel;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MovieListViewModel extends BaseViewModel<MovieListNavigator> {
    private final MutableLiveData<List<Movie>> movieList;

    public MovieListViewModel(DataRepository dataRepository, SchedulerProvider schedulerProvider) {
        super(dataRepository, schedulerProvider);

        movieList = new MutableLiveData<>();
        getMovies();
    }

    public void getMovies() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataRepository().getMovies("en","release_date.desc",
                false, false, 1, "2019-07-18", "2019-08-18")
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(moviesResponse -> {
                    setIsLoading(false);
                    //movieList = moviesResponse.getMovies();
                    movieList.setValue(moviesResponse.getMovies());
                }, throwable -> {
                    setIsLoading(false);
                }));

    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }
}
