package com.teknasyon.relaxingsong;

import android.util.Log;

import com.teknasyon.relaxingsong.dependencyinjection.AppComponent;
import com.teknasyon.relaxingsong.dependencyinjection.DaggerAppComponent;
import com.teknasyon.relaxingsong.dependencyinjection.module.InformationManagerModule;
import com.teknasyon.relaxingsong.dependencyinjection.module.RetrofitClientModule;
import com.teknasyon.relaxingsong.manager.InformationManager;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by anilkara on 13.10.2018.
 */

public class MainApplication extends DaggerApplication {

    private static final String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "MainApplication is created.");
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = getAppComponent();
        appComponent.inject(this);
        return appComponent;
    }

    private AppComponent getAppComponent() {
        InformationManagerModule informationManagerModule = new InformationManagerModule(this);
        RetrofitClientModule retrofitClientModule = new RetrofitClientModule(this);
        return DaggerAppComponent.builder()
                .informationManagerModule(informationManagerModule)
                .retrofitClientModule(retrofitClientModule)
                .application(this).build();
    }

}
