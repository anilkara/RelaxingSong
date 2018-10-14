package com.teknasyon.relaxingsong.fragments.library;

import com.teknasyon.relaxingsong.base.BasePresenter;
import com.teknasyon.relaxingsong.base.BaseView;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;

import java.util.List;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface LibraryContract {

    interface View extends BaseView<LibraryContract.Presenter> {

        void onInit();

        void onSuccessfulLibraryService(List<LibraryResponse> libraryResponseList);

        void showLoadingView();
    }

    interface Presenter extends BasePresenter<LibraryContract.View> {
        void init();

        void callLibrariesService();
    }

}
