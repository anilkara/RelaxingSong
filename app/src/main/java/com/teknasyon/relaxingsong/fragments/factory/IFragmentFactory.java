package com.teknasyon.relaxingsong.fragments.factory;

import android.content.Context;

import com.teknasyon.relaxingsong.Base.BaseFragment;
import com.teknasyon.relaxingsong.fragments.FragmentName;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface IFragmentFactory {

    BaseFragment createDirectionFragment(int fragmentName);

    String createFragmentHeader(Context context, int fragmentName);
}
