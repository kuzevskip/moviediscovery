package com.pavlekuzevski.moviediscovery;

import com.pavlekuzevski.moviediscovery.data.DataRepository;
import com.pavlekuzevski.moviediscovery.ui.main.MainViewModel;
import com.pavlekuzevski.moviediscovery.ui.movielist.MovieListViewModel;
import com.pavlekuzevski.moviediscovery.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataRepository dataRepository;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataRepository dataRepository,
                                    SchedulerProvider schedulerProvider) {
        this.dataRepository = dataRepository;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataRepository,schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(MovieListViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieListViewModel(dataRepository,schedulerProvider);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
