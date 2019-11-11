package com.pavlekuzevski.moviediscovery.ui.main;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.data.model.Movie;
import com.pavlekuzevski.moviediscovery.ui.base.BaseViewModel;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private final MutableLiveData<List<Movie>> movieList;
    private final MutableLiveData<String> dateFrom;
    private final MutableLiveData<String> dateTo;

    public MainViewModel(DataRepository dataRepository, SchedulerProvider schedulerProvider) {
        super(dataRepository, schedulerProvider);
        movieList = new MutableLiveData<>();
        dateFrom = new MutableLiveData<>();
        dateTo = new MutableLiveData<>();
    }

    public void getMovies() {
        setIsLoading(true);
        getNavigator().showMoviesList();
        getCompositeDisposable().add(getDataRepository().getMovies("en","release_date.desc",
                false, false, 1, dateFrom.getValue(), dateTo.getValue())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(moviesResponse -> {
                    setIsLoading(false);
                    movieList.setValue(moviesResponse.getMovies());
                }, throwable -> {
                    setIsLoading(false);
                }));
    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }

    public void setDateFrom(String dateFrom){
        this.dateFrom.setValue(dateFrom);
    }

    public void setDateTo(String dateTo){
        this.dateTo.setValue(dateTo);
    }
}
