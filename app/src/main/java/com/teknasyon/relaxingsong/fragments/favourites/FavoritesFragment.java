package com.teknasyon.relaxingsong.fragments.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.customviews.LoadableView;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.dependencyinjection.ActivityScoped;
import com.teknasyon.relaxingsong.fragments.favourites.adapter.FavouriteListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */

@ActivityScoped
public class FavoritesFragment extends BaseFragment implements FavouritesContract.View,
        OnFavouriteAdapterListener{

    @BindView(R.id.rv_favourite_list)
    RecyclerView favouriteRecyclerView;

    @BindView(R.id.lv_favourites)
    LoadableView favouritesLoadableView;

    @Inject
    FavouritesPresenter mPresenter;

    private FavouriteListAdapter favouriteListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favourites, container, false);
        ButterKnife.bind(this, root);
        mPresenter.takeView(this); // to initialize view for presenter
        mPresenter.init();
        mPresenter.callFavouriteList();
        return root;
    }

    @Override
    public void showServerError(String errorMessage) {
        favouritesLoadableView.showError(errorMessage);
    }

    @Override
    public void onInit() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        favouriteListAdapter = new FavouriteListAdapter(getContext(), null, this);
        favouriteRecyclerView.setLayoutManager(linearLayoutManager);
        favouriteRecyclerView.setAdapter(favouriteListAdapter);
    }

    @Override
    public void onSuccessFulFavouriteList(List<RelaxingSong> favouriteSongList) {
        favouriteListAdapter.setFavouriteList(favouriteSongList);
        favouritesLoadableView.showContent();
    }

    // shows loading view or not
    @Override
    public void setLoadingView() {
        favouritesLoadableView.showLoading();
    }

    @Override
    public void showInfoMessage(String message) {
        favouritesLoadableView.showError(message);
    }

    @Override
    public void onDestroy() {
        // to remove view from presenter
        mPresenter.dropView();
        super.onDestroy();
    }

    // Favourite Dismiss listener
    @Override
    public void onFavouriteDismiss(RelaxingSong relaxingSong) {
        mPresenter.removeFavouriteSong(relaxingSong);
    }
}