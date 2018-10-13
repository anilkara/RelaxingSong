package com.teknasyon.relaxingsong.fragments.library;

import com.teknasyon.relaxingsong.base.BasePresenter;
import com.teknasyon.relaxingsong.base.BaseView;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface LibraryContract {

    interface View extends BaseView<LibraryContract.Presenter> {

        void onInit();
    }

    interface Presenter extends BasePresenter<LibraryContract.View> {
        void init();
    }

}
