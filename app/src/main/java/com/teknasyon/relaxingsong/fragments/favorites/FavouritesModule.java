package com.teknasyon.relaxingsong.fragments.favorites;

import com.teknasyon.relaxingsong.dependencyinjection.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by anilkara on 13.10.2018.
 */

@Module
public abstract class FavouritesModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract FavoritesFragment getFavoritesFragment();


    @FragmentScoped
    @Binds
    abstract FavoritesContract.Presenter getFavoritesPresenter(FavoritesPresenter presenter);

}
