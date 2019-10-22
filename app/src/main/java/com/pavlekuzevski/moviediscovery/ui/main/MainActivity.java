package com.pavlekuzevski.moviediscovery.ui.main;

import android.os.Bundle;

import com.pavlekuzevski.moviediscovery.BR;
import com.pavlekuzevski.moviediscovery.R;
import com.pavlekuzevski.moviediscovery.ViewModelProviderFactory;
import com.pavlekuzevski.moviediscovery.databinding.ActivityMainBinding;
import com.pavlekuzevski.moviediscovery.ui.base.BaseActivity;
import com.pavlekuzevski.moviediscovery.utils.CalendarUtils;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator{

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


}
