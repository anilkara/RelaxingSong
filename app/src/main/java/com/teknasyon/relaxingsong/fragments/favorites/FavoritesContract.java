package com.teknasyon.relaxingsong.fragments.favorites;

import com.teknasyon.relaxingsong.base.BaseView;
import com.teknasyon.relaxingsong.base.BasePresenter;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;

import java.util.List;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface FavoritesContract {

    interface View extends BaseView<FavoritesContract.Presenter> {

        void onInit();

        void onSuccessFulFavouriteList(List<RelaxingSong> relaxingSongList);

        void setLoadingView();

        void showInfoMessage(String message);
    }

    interface Presenter extends BasePresenter<FavoritesContract.View> {
        void init();

        void callFavouriteList();

        void removeFavouriteSong(RelaxingSong relaxingSong);
    }

}
