package com.pavlekuzevski.moviediscovery;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.ui.main.MainViewModel;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private MainViewModel mainViewModel;

    @Inject
    public ViewModelProviderFactory(DataRepository dataRepository,
                                    SchedulerProvider schedulerProvider) {
        mainViewModel = new MainViewModel(dataRepository,schedulerProvider);
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) mainViewModel;
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
