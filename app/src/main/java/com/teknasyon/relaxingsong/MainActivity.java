package com.teknasyon.relaxingsong;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.fragments.favourites.FavoritesFragment;
import com.teknasyon.relaxingsong.fragments.manager.FragmentManager;
import com.teknasyon.relaxingsong.util.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @BindView(R.id.fl_fragment_container)
    FrameLayout fragmentContainer;

    @BindView(R.id.tv_my_favourites)
    TextView favouritesTextView;

    @BindView(R.id.tv_my_libraries)
    TextView librariesTextView;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = new FragmentManager();
        fragmentManager.showFavouritesFragment(this, null);

    }


    @OnClick(R.id.tv_my_favourites)
    public void clickFavouritesText() {
        fragmentManager.showFavouritesFragment(this, null);
    }

    @OnClick(R.id.tv_my_libraries)
    public void clickLibrariesText() {
        fragmentManager.showLibraryFragment(this, null);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            fragmentManager.showFavouritesFragment(this, null);
        }
    }

}
