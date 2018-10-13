package com.teknasyon.relaxingsong.fragments.favourites;

import com.teknasyon.relaxingsong.dependencyinjection.FragmentScoped;

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
}
