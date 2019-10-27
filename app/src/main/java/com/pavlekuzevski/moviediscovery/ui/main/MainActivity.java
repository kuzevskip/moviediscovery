package com.pavlekuzevski.moviediscovery.ui.main;

import android.os.Bundle;

import com.pavlekuzevski.moviediscovery.BR;
import com.pavlekuzevski.moviediscovery.R;
import com.pavlekuzevski.moviediscovery.ViewModelProviderFactory;
import com.pavlekuzevski.moviediscovery.databinding.ActivityMainBinding;
import com.pavlekuzevski.moviediscovery.ui.base.BaseActivity;
import com.pavlekuzevski.moviediscovery.ui.movielist.MovieListFragment;
import com.pavlekuzevski.moviediscovery.utils.CalendarUtils;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Inject
    ViewModelProviderFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = getViewDataBinding();
        mainViewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    public void selectBeginDate() {
        CalendarUtils.selectDate(this, activityMainBinding.dateFrom);
    }

    @Override
    public void selectEndDate() {
        CalendarUtils.selectDate(this, activityMainBinding.dateTo);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void showMoviesList() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                //.setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.mainRoot, MovieListFragment.newInstance(), MovieListFragment.TAG)
                .commit();
    }


}
