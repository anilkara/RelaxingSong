package com.teknasyon.relaxingsong.dependencyinjection;

import android.app.Application;

import com.teknasyon.relaxingsong.MainApplication;
import com.teknasyon.relaxingsong.data.RetrofitClient;
import com.teknasyon.relaxingsong.dependencyinjection.module.ActivityBindingModule;
import com.teknasyon.relaxingsong.dependencyinjection.module.InformationManagerModule;
import com.teknasyon.relaxingsong.dependencyinjection.module.RetrofitClientModule;
import com.teknasyon.relaxingsong.manager.InformationManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by anilkara on 13.10.2018.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        InformationManagerModule.class,
        RetrofitClientModule.class
})

public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(MainApplication application);

    void inject(InformationManagerModule informationManagerModule);

    void inject(RetrofitClientModule retrofitClientModule);


    @Override
    void inject(DaggerApplication instance);


    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent.Builder informationManagerModule(InformationManagerModule informationManagerModule);

        AppComponent.Builder retrofitClientModule(RetrofitClientModule retrofitClientModule);

        AppComponent build();
    }
}
