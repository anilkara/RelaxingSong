package com.teknasyon.relaxingsong.fragments.favourites;

import com.teknasyon.relaxingsong.base.AbstractPresenter;

import javax.inject.Inject;

/**
 * Created by anilkara on 13.10.2018.
 */

public class FavouritesPresenter extends AbstractPresenter<FavouritesContract.View>
        implements FavouritesContract.Presenter {

    @Inject
    FavouritesPresenter() {
    }

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }
}
