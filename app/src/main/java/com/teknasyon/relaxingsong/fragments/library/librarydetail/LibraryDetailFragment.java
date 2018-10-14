package com.teknasyon.relaxingsong.fragments.library.librarydetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.constant.BundleCodes;
import com.teknasyon.relaxingsong.customviews.LoadableView;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.fragments.favourites.adapter.FavouriteListAdapter;
import com.teknasyon.relaxingsong.fragments.library.adapter.LibraryListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */


public class LibraryDetailFragment extends BaseFragment implements LibraryDetailContract.View {

    @BindView(R.id.rv_library_detail_list)
    RecyclerView libraryDetgailRecyclerView;

    @BindView(R.id.lv_library_detail)
    LoadableView libraryDetailLoadableView;

    @Inject
    LibraryDetailPresenter mPresenter;

    private FavouriteListAdapter favouriteListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_library_detail, container, false);
        ButterKnife.bind(this, root);
        mPresenter.takeView(this);
        mPresenter.init();
        return root;
    }

    @Override
    public void showServerError(String errorMessage) {
        libraryDetailLoadableView.showError(errorMessage);
    }

    @Override
    public void onInit() {
        libraryDetailLoadableView.showLoading();
        if (getArguments() != null) {
            List<RelaxingSong> relaxingSongList = (List<RelaxingSong>) getArguments().getSerializable(BundleCodes.RELAXING_SONG_LIST); // sorry for that
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            favouriteListAdapter = new FavouriteListAdapter(getContext(), relaxingSongList);
            libraryDetgailRecyclerView.setLayoutManager(linearLayoutManager);
            libraryDetgailRecyclerView.setAdapter(favouriteListAdapter);
            libraryDetailLoadableView.showContent();
        } else {
            libraryDetailLoadableView.showError(getString(R.string.no_detail_library_message));
        }
    }

    @Override
    public void showLoadingView() {
        libraryDetailLoadableView.showLoading();
    }

    @Override
    public void onDestroy() {
        // to remove view from presenter
        mPresenter.dropView();
        super.onDestroy();
    }
}
