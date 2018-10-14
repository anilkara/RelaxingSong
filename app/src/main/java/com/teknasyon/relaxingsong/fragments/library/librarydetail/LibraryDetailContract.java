package com.teknasyon.relaxingsong.fragments.library.librarydetail;

import com.teknasyon.relaxingsong.base.BasePresenter;
import com.teknasyon.relaxingsong.base.BaseView;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;

import java.util.List;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface LibraryDetailContract {

    interface View extends BaseView<LibraryDetailContract.Presenter> {

        void onInit();

        void showLoadingView();
    }

    interface Presenter extends BasePresenter<LibraryDetailContract.View> {
        void init();
    }

}
