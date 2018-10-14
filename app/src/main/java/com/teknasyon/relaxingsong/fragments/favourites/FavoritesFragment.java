package com.teknasyon.relaxingsong.fragments.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.customviews.LoadableView;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.dependencyinjection.ActivityScoped;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */

@ActivityScoped
public class FavoritesFragment extends BaseFragment implements FavouritesContract.View {

    @BindView(R.id.tv_main_text)
    TextView mainTextView;

    @BindView(R.id.lv_favourites)
    LoadableView favouritesLoadableView;

    @Inject
    FavouritesPresenter mPresenter;

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
        //todo will be implemented after dialog builder create.
    }

    @Override
    public void onInit() {
        mainTextView.setText("ddd");
        // will be implemented view operations
    }

    @Override
    public void onSuccessFulFavouriteList(List<RelaxingSong> relaxingSongList) {
        favouritesLoadableView.showContent();
    }

    // shows loading view or not
    @Override
    public void setLoadingView() {
        favouritesLoadableView.showLoading();
    }

    @Override
    public void onDestroy() {
        // to remove view from presenter
        mPresenter.dropView();
        super.onDestroy();
    }
}