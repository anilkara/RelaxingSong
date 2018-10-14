package com.teknasyon.relaxingsong.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.base.BaseFragment;

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
