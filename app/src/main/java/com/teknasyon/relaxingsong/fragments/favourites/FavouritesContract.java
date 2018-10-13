package com.teknasyon.relaxingsong.fragments.favourites;

import com.teknasyon.relaxingsong.base.BaseView;
import com.teknasyon.relaxingsong.base.BasePresenter;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface FavouritesContract {

    interface View extends BaseView<FavouritesContract.Presenter> {

        void onInit();

        void onSuccessFulFavouriteList();
    }

    interface Presenter extends BasePresenter<FavouritesContract.View> {
        void init();

        void callFavouriteList();
    }

}
