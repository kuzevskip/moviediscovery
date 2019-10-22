package com.pavlekuzevski.moviediscovery.ui.base;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<N> extends ViewModel {

    private DataRepository dataRepository;
    private SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable;

    private WeakReference<N> navigator;

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

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
