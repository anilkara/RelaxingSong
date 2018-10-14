package com.teknasyon.relaxingsong.fragments.library.librarydetail;

import com.teknasyon.relaxingsong.base.AbstractPresenter;
import com.teknasyon.relaxingsong.data.RetrofitClient;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anilkara on 13.10.2018.
 */

@Singleton
public class LibraryDetailPresenter extends AbstractPresenter<LibraryDetailContract.View>
        implements LibraryDetailContract.Presenter {

    @Inject
    LibraryDetailPresenter() {
    }

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }

}
