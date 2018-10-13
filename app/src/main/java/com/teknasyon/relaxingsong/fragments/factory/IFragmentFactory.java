package com.teknasyon.relaxingsong.fragments.factory;

import android.content.Context;

import com.teknasyon.relaxingsong.base.BaseFragment;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface IFragmentFactory {

    BaseFragment createDirectionFragment(int fragmentName);

    String createFragmentHeader(Context context, int fragmentName);
}
