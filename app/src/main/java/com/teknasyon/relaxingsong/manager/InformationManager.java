package com.teknasyon.relaxingsong.manager;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by anilkara on 13.10.2018.
 */

public class InformationManager {

    private Context context;

    @Inject
    public InformationManager informationManager;

    public void setContext(Context context) {
        this.context = context;
    }

    public InformationManager(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
