package com.teknasyon.relaxingsong.base;

import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * Created by anilkara on 13.10.2018.
 */

public class AbstractPresenter<T> implements BasePresenter<T> {

    @Nullable
    private T view;

    @Nullable
    protected T getView() {
        return view;
    }

    @Override
    public void takeView(T view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }
}
