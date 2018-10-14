package com.teknasyon.relaxingsong.fragments.library.librarydetail;

import com.teknasyon.relaxingsong.base.AbstractPresenter;
import com.teknasyon.relaxingsong.data.RetrofitClient;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.fragments.favourites.FavouritesPresenter;

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

public class LibraryDetailPresenter extends AbstractPresenter<LibraryDetailContract.View>
        implements LibraryDetailContract.Presenter {

    private List<RelaxingSong> libraryDetailList;

    @Inject
    LibraryDetailPresenter() {
    }

    @Inject
    FavouritesPresenter favouritesPresenter;

    @Override
    public void init() {
        if (getView() == null) return;
        getView().onInit();
    }

    @Override
    public void setLibraryDetailData(List<RelaxingSong> libraryDetailList) {
        this.libraryDetailList = libraryDetailList;
        prepareData();
        if (getView() != null){
            getView().onLoadDataToView(this.libraryDetailList);
        }
    }

    // sets library songs isFavourite flag if the song is favourite
    private void prepareData(){
        List<RelaxingSong> favouriteSongList = favouritesPresenter.getRelaxingSongList();
        boolean isExist;
        for (RelaxingSong relaxingSong : libraryDetailList) {
            isExist = false;
            for (RelaxingSong favouriteSong : favouriteSongList) {
                if (relaxingSong.id == favouriteSong.id) {
                    isExist = true;
                    break;
                }
            }
            relaxingSong.isFavourite = isExist;
        }

    }

    @Override
    public void changedSongState(RelaxingSong relaxingSong) {
        List<RelaxingSong> favouriteSongList = favouritesPresenter.getRelaxingSongList();
        if (relaxingSong.isFavourite){
            shouldAddSong(favouriteSongList, relaxingSong);
        } else {
            shouldRemoveSong(favouriteSongList, relaxingSong);
        }
        favouritesPresenter.setRelaxingSongList(favouriteSongList);
    }

    //add item if is no exist on list
    private void shouldAddSong(List<RelaxingSong> favouriteSongList, RelaxingSong relaxingSong){
        boolean isAdd = true;
        for (RelaxingSong favouriteSong: favouriteSongList) {
            if (relaxingSong.id == favouriteSong.id){
                isAdd = false;
                break;
            }
        }
        if (isAdd)
            favouriteSongList.add(relaxingSong);

    }

    //remove item if exist on list
    private void shouldRemoveSong(List<RelaxingSong> favouriteSongList, RelaxingSong relaxingSong){
        for (RelaxingSong favouriteSong: favouriteSongList) {
            if (relaxingSong.id == favouriteSong.id){
                favouriteSongList.remove(relaxingSong);
                break;
            }
        }
    }

}
