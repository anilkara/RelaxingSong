package com.teknasyon.relaxingsong.fragments.library.librarydetail;

import com.teknasyon.relaxingsong.dependencyinjection.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by anilkara on 13.10.2018.
 */

@Module
public abstract class LibraryDetailModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LibraryDetailFragment getLibraryFragment();


    @FragmentScoped
    @Binds
    abstract LibraryDetailContract.Presenter getLibraryPresenter(LibraryDetailPresenter presenter);

}
