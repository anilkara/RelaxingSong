package com.teknasyon.relaxingsong.fragments.factory;

import android.content.Context;

import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.fragments.FragmentName;
import com.teknasyon.relaxingsong.fragments.favourites.FavoritesFragment;
import com.teknasyon.relaxingsong.fragments.library.LibraryFragment;
import com.teknasyon.relaxingsong.fragments.library.librarydetail.LibraryDetailFragment;

/**
 * Created by anilkara on 13.10.2018.
 */

public class FragmentFactory implements IFragmentFactory {

    /**
     * to create related fragment to given parameter type
     * @param fragmentName direction fragment type
     * @return fragment type of input type if it exist
     */
    @Override
    public BaseFragment createDirectionFragment(int fragmentName) {

        BaseFragment baseFragment = null;
        switch (fragmentName){
            case FragmentName.FAVOURITE:
                baseFragment = new FavoritesFragment();
                break;

            case FragmentName.LIBRARIES:
                baseFragment = new LibraryFragment();
                break;

            case FragmentName.LIBRARY_DETAIL:
                baseFragment = new LibraryDetailFragment();
                break;

            default:
                baseFragment = null;
                break;
        }

        return baseFragment;
    }

    /**
     * Fragment header creaater function
     * @param fragmentName creates fragment by given fragmentName
     * @return return header by given fragmentName
     */
    @Override
    public String createFragmentHeader(Context context, int fragmentName) {
        String header;
        switch (fragmentName){
            case FragmentName.FAVOURITE:
                header = context.getString(R.string.favourites_text);
                break;

            case FragmentName.LIBRARIES:
                header = context.getString(R.string.library_text);
                break;

            default:
                header = "";
                break;
        }

        return header;
    }
}
