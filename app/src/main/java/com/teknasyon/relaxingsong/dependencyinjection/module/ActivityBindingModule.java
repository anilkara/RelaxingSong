package com.teknasyon.relaxingsong.dependencyinjection.module;

import com.teknasyon.relaxingsong.MainActivity;
import com.teknasyon.relaxingsong.dependencyinjection.ActivityScoped;
import com.teknasyon.relaxingsong.fragments.favourites.FavouritesModule;
import com.teknasyon.relaxingsong.fragments.library.LibraryModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by anilkara on 13.10.2018.
 */

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            FavouritesModule.class,
            LibraryModule.class
    }
    )
    abstract MainActivity mainActivity();
}
