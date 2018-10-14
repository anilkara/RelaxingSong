package com.teknasyon.relaxingsong.fragments;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by anilkara on 13.10.2018.
 */

@IntDef({
        FragmentName.FAVOURITE,
        FragmentName.LIBRARIES,
        FragmentName.LIBRARY_DETAIL,
})
@Retention(RetentionPolicy.SOURCE)
public @interface FragmentName {
    int FAVOURITE = 0;
    int LIBRARIES = 1;
    int LIBRARY_DETAIL = 2;
}
