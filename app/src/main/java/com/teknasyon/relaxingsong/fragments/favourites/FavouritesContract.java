package com.teknasyon.relaxingsong.fragments.favourites;

import android.view.View;

import com.teknasyon.relaxingsong.base.BaseView;
import com.teknasyon.relaxingsong.base.BasePresenter;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;

import java.util.List;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface FavouritesContract {

    interface View extends BaseView<FavouritesContract.Presenter> {

        void onInit();

        void onSuccessFulFavouriteList(List<RelaxingSong> relaxingSongList);

        void setLoadingView();
    }

    interface Presenter extends BasePresenter<FavouritesContract.View> {
        void init();

        void callFavouriteList();
    }

}
