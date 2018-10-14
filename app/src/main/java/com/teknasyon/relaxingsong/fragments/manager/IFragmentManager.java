package com.teknasyon.relaxingsong.fragments.manager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface IFragmentManager {

    void showFavouritesFragment(FragmentActivity context, Bundle bundle);

    void showLibraryFragment(FragmentActivity context, Bundle bundle);

    void showLibraryDetailFragment(FragmentActivity context, Bundle bundle);

}
