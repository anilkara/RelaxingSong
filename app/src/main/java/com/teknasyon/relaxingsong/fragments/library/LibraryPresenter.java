package com.teknasyon.relaxingsong.fragments.library;

import com.teknasyon.relaxingsong.base.AbstractPresenter;
import com.teknasyon.relaxingsong.fragments.favourites.FavouritesContract;

import javax.inject.Inject;

/**
 * Created by anilkara on 13.10.2018.
 */

public class LibraryPresenter extends AbstractPresenter<LibraryContract.View>
        implements LibraryContract.Presenter {

    @Inject
    LibraryPresenter() {
    }

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }
}
