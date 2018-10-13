package com.teknasyon.relaxingsong.fragments.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teknasyon.relaxingsong.Base.BaseFragment;
import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.dependencyinjection.ActivityScoped;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */

@ActivityScoped
public class FavoritesFragment extends BaseFragment {

    @Inject
    FavoritesFragment favoritesFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favourites, container, false);
        ButterKnife.bind(this, root);
        return root;
    }
}