package com.teknasyon.relaxingsong.fragments.favourites;

import android.widget.Toast;

import com.teknasyon.relaxingsong.base.AbstractPresenter;
import com.teknasyon.relaxingsong.data.APIService;
import com.teknasyon.relaxingsong.data.RetrofitClient;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.manager.InformationManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anilkara on 13.10.2018.
 */

public class FavouritesPresenter extends AbstractPresenter<FavouritesContract.View>
        implements FavouritesContract.Presenter {

    @Inject
    RetrofitClient retrofitClient;

    @Inject
    InformationManager informationManager;

    @Inject
    FavouritesPresenter() {
    }

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }

    @Override
    public void callFavouriteList() {

        retrofitClient.getRetrofitService().getFavouriteList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RelaxingSong>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<RelaxingSong> relaxingSongs) {
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {
                               }
                           }
                );
    }
}
