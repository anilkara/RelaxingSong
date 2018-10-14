package com.teknasyon.relaxingsong.fragments.favourites;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.base.AbstractPresenter;
import com.teknasyon.relaxingsong.data.RetrofitClient;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.manager.InformationManager;

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
public class FavouritesPresenter extends AbstractPresenter<FavouritesContract.View>
        implements FavouritesContract.Presenter {

    @Inject
    RetrofitClient retrofitClient;

    @Inject
    InformationManager informationManager;

    @Inject
    FavouritesPresenter() {
    }

    private List<RelaxingSong> relaxingSongList;

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }

    @Override
    public void callFavouriteList() {
        if (getView() == null) return;
        getView().setLoadingView();

        if (relaxingSongList != null && getView() != null){
            if (relaxingSongList.isEmpty()){
                getView().showInfoMessage(informationManager.getContext().getString(R.string.no_favourite_message));
            } else {
                getView().onSuccessFulFavouriteList(relaxingSongList);
            }
            return;
        }
        retrofitClient.getRetrofitService().getFavouriteList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RelaxingSong>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<RelaxingSong> relaxingSongs) {
                                   relaxingSongList = relaxingSongs;
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {
                                   if (getView() != null){
                                       getView().onSuccessFulFavouriteList(relaxingSongList);
                                   }
                               }
                           }
                );
    }

    @Override
    public void removeFavouriteSong(RelaxingSong relaxingSong) {
        if (relaxingSongList != null) {
            relaxingSongList.remove(relaxingSong);
            if (relaxingSongList.isEmpty() && getView() != null){
                getView().showInfoMessage(informationManager.getContext().getString(R.string.no_favourite_message));
            } else if (getView() != null){
                getView().onSuccessFulFavouriteList(relaxingSongList);
            }
        } else if (getView() != null){
            getView().showInfoMessage(informationManager.getContext().getString(R.string.no_favourite_message));
        }
    }

    public List<RelaxingSong> getRelaxingSongList() {
        return relaxingSongList;
    }

    public void setRelaxingSongList(List<RelaxingSong> relaxingSongList) {
        this.relaxingSongList = relaxingSongList;
    }
}
