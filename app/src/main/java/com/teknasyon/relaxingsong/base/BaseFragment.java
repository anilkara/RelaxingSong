package com.teknasyon.relaxingsong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Created by anilkara on 13.10.2018.
 */

public class BaseFragment extends DaggerFragment {

    @Inject
    public BaseFragment() {
        //Nothing is done in this constructor
    }

    /**
     * To show open fragment name on console
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FragmentInfo", this.getClass().getCanonicalName());
    }

}
