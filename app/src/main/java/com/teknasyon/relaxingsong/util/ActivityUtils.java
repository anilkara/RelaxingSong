package com.teknasyon.relaxingsong.util;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by anilkara on 14.10.2018.
 */

public class ActivityUtils {

    // clear all fragments from fragment stack
    public static void clearAllFragmentFromStack(FragmentActivity activity) {
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
