package com.teknasyon.relaxingsong.fragments.library;

import com.teknasyon.relaxingsong.base.AbstractPresenter;
import com.teknasyon.relaxingsong.data.RetrofitClient;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.fragments.favourites.FavouritesContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anilkara on 13.10.2018.
 */

public class LibraryPresenter extends AbstractPresenter<LibraryContract.View>
        implements LibraryContract.Presenter {

    private List<LibraryResponse> libraryResponseList;

    @Inject
    LibraryPresenter() {
    }

    @Inject
    RetrofitClient retrofitClient;

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }

    @Override
    public void callLibrariesService() {
        if (getView() == null) return;
        getView().showLoadingView();

        retrofitClient.getRetrofitService().getLibraryList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LibraryResponse>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<LibraryResponse> response) {
                                   libraryResponseList = response;
                               }

                               @Override
                               public void onError(Throwable e) {
                                   if (getView() != null){
                                       getView().showServerError(e.getMessage());
                                   }
                               }

                               @Override
                               public void onComplete() {
                                   if (getView() != null){
                                       getView().onSuccessfulLibraryService(libraryResponseList);
                                   }
                               }
                           }
                );

    }
}
