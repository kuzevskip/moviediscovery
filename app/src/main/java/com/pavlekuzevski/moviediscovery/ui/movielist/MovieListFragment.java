package com.pavlekuzevski.moviediscovery.ui.movielist;

import android.os.Bundle;
import android.view.View;

import com.pavlekuzevski.moviediscovery.BR;
import com.pavlekuzevski.moviediscovery.R;
import com.pavlekuzevski.moviediscovery.ViewModelProviderFactory;
import com.pavlekuzevski.moviediscovery.databinding.FragmentMovieListBinding;
import com.pavlekuzevski.moviediscovery.ui.base.BaseFragment;
import com.pavlekuzevski.moviediscovery.ui.main.MainViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MovieListFragment extends BaseFragment<FragmentMovieListBinding, MainViewModel> {
    public static final String TAG = MovieListFragment.class.getSimpleName();

    @Inject
    MovieListAdapter movieListAdapter;

    FragmentMovieListBinding fragmentMovieListBinding;

    @Inject
    LinearLayoutManager layoutManager;

    @Inject
    ViewModelProviderFactory factory;

    private MainViewModel viewModel;

    public static MovieListFragment newInstance() {
        Bundle args = new Bundle();
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    public MainViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        return viewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMovieListBinding = getViewDataBinding();
        fragmentMovieListBinding.moviesRecyclerView.setLayoutManager(layoutManager);
        fragmentMovieListBinding.moviesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fragmentMovieListBinding.moviesRecyclerView.setAdapter(movieListAdapter);
    }
}
