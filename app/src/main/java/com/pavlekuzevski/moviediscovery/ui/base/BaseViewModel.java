package com.pavlekuzevski.moviediscovery.ui.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private final ObservableBoolean isLoading = new ObservableBoolean();

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }
}
