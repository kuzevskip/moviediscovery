package com.pavlekuzevski.moviediscovery.ui.main;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.ui.base.BaseViewModel;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    public MainViewModel(DataRepository dataRepository, SchedulerProvider schedulerProvider) {
        super(dataRepository, schedulerProvider);
    }

    public void getMovies() {
        setIsLoading(true);
        getNavigator().showMoviesList();
    }

    public void onBeginDateClickListener(){
        getNavigator().selectBeginDate();
    }

    public void onEndDateClickListener(){
        getNavigator().selectEndDate();
    }
}
