package com.teknasyon.relaxingsong.fragments.library;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */


public class LibraryFragment extends BaseFragment implements LibraryContract.View{

    @Inject
    LibraryPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_libraries, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void showServerError(String errorMessage) {
        //todo will be implemented after dialog builder create.
    }

    @Override
    public void onInit() {
        // will be implemented view operations
    }

    @Override
    public void onDestroy() {
        // to remove view from presenter
        mPresenter.dropView();
        super.onDestroy();
    }
}
