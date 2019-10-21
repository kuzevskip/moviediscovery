package com.pavlekuzevski.moviediscovery.ui.base;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    private DataRepository dataRepository;
    private SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable;

    private final ObservableBoolean isLoading = new ObservableBoolean();

    public BaseViewModel(DataRepository dataManager,
                         SchedulerProvider schedulerProvider) {
        this.dataRepository = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
