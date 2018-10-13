package com.teknasyon.relaxingsong.fragments.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.dependencyinjection.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */

@ActivityScoped
public class FavoritesFragment extends BaseFragment  implements FavouritesContract.View {

    @BindView(R.id.tv_main_text)
    TextView mainTextView;

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
    public void onSuccessFulFavouriteList() {

    }

    @Override
    public void onDestroy() {
        // to remove view from presenter
        mPresenter.dropView();
        super.onDestroy();
    }
}