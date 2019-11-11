package com.pavlekuzevski.moviediscovery.ui.selectdates;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.pavlekuzevski.moviediscovery.BR;
import com.pavlekuzevski.moviediscovery.R;
import com.pavlekuzevski.moviediscovery.ViewModelProviderFactory;
import com.pavlekuzevski.moviediscovery.databinding.FragmentSelectdatesBinding;
import com.pavlekuzevski.moviediscovery.ui.base.BaseFragment;
import com.pavlekuzevski.moviediscovery.ui.main.MainViewModel;
import com.pavlekuzevski.moviediscovery.utils.CalendarUtils;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class SelectDatesFragment extends BaseFragment<FragmentSelectdatesBinding, MainViewModel> {

    public static final String TAG = SelectDatesFragment.class.getSimpleName();

    private MainViewModel viewModel;

    private FragmentSelectdatesBinding fragmentSelectdatesBinding;

    public static SelectDatesFragment newInstance() {
        Bundle args = new Bundle();
        SelectDatesFragment fragment = new SelectDatesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_selectdates;
    }

    @Override
    public MainViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        return viewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentSelectdatesBinding = getViewDataBinding();
        fragmentSelectdatesBinding.dateFrom.setOnClickListener(dateFromView -> CalendarUtils.selectDate(getContext(), (EditText) dateFromView));
        fragmentSelectdatesBinding.dateFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.setDateFrom(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        fragmentSelectdatesBinding.dateTo.setOnClickListener(dateTo -> CalendarUtils.selectDate(getContext(), (EditText) dateTo));
        fragmentSelectdatesBinding.dateTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.setDateTo(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
