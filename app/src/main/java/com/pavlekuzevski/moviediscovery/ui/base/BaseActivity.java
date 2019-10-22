package com.pavlekuzevski.moviediscovery.ui.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.AndroidInjection;

public abstract class BaseActivity <T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    private T viewDataBinding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBindings();
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    @LayoutRes
    public abstract int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    private void performDataBindings() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        if(viewModel == null){
            viewModel = getViewModel();
        }
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        viewDataBinding.executePendingBindings();
    }
}
