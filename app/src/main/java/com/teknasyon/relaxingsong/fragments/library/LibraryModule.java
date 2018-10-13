package com.teknasyon.relaxingsong.fragments.library;

import com.teknasyon.relaxingsong.dependencyinjection.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by anilkara on 13.10.2018.
 */

@Module
public abstract class LibraryModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LibraryFragment getLibraryFragment();
}
