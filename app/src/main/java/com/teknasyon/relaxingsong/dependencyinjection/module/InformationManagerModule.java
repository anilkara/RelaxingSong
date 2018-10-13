package com.teknasyon.relaxingsong.dependencyinjection.module;

import android.content.Context;

import com.teknasyon.relaxingsong.manager.InformationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anilkara on 13.10.2018.
 */

@Module
public class InformationManagerModule {
    private Context context;

    public InformationManagerModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public InformationManager provideInformationManager() {
        return new InformationManager(context);
    }
}
