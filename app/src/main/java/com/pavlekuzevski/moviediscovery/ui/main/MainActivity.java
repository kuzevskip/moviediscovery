package com.pavlekuzevski.moviediscovery.ui.main;

import android.os.Bundle;

import com.pavlekuzevski.moviediscovery.BR;
import com.pavlekuzevski.moviediscovery.R;
import com.pavlekuzevski.moviediscovery.ui.base.BaseActivity;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return mainViewModel;
    }
}
