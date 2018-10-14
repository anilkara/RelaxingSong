package com.teknasyon.relaxingsong.fragments.manager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.fragments.FragmentName;
import com.teknasyon.relaxingsong.fragments.factory.FragmentFactory;

/**
 * Created by anilkara on 13.10.2018.
 */
// Fragment manager class will be arranged if time remains :/
public class FragmentManager implements IFragmentManager {

    private FragmentFactory fragmentFactory;

    public FragmentManager() {
        fragmentFactory = new FragmentFactory();
    }

    @Override
    public void showFavouritesFragment(FragmentActivity context, Bundle bundle) {
        android.support.v4.app.FragmentManager fragmentManager = context.getSupportFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment baseFragment = fragmentFactory.createDirectionFragment(FragmentName.FAVOURITE);
        baseFragment.setArguments(bundle);
        transaction.replace(R.id.fl_fragment_container, baseFragment);
        transaction.addToBackStack(baseFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void showLibraryFragment(FragmentActivity context, Bundle bundle) {
        android.support.v4.app.FragmentManager fragmentManager = context.getSupportFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment baseFragment = fragmentFactory.createDirectionFragment(FragmentName.LIBRARIES);
        baseFragment.setArguments(bundle);
        transaction.replace(R.id.fl_fragment_container, baseFragment);
        transaction.addToBackStack(baseFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void showLibraryDetailFragment(FragmentActivity context, Bundle bundle) {
        android.support.v4.app.FragmentManager fragmentManager = context.getSupportFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment baseFragment = fragmentFactory.createDirectionFragment(FragmentName.LIBRARY_DETAIL);
        baseFragment.setArguments(bundle);
        transaction.replace(R.id.fl_fragment_container, baseFragment);
        transaction.addToBackStack(baseFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

}
