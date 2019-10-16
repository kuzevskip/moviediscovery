package com.pavlekuzevski.moviediscovery.ui.main;

import com.pavlekuzevski.moviediscovery.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {

    public void getMovies() {
        setIsLoading(!getIsLoading().get());
    }
}
