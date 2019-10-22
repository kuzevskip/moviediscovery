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
        getCompositeDisposable().add(getDataRepository().getMovies("en","release_date.desc",
                false, false, 1, "2019-07-18", "2019-08-18")
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(moviesResponse -> {
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }

    public void onBeginDateClickListener(){
        getNavigator().selectBeginDate();
    }

    public void onEndDateClickListener(){
        getNavigator().selectEndDate();
    }
}
