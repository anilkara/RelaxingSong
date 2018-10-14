package com.teknasyon.relaxingsong.fragments.library;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teknasyon.relaxingsong.base.BaseFragment;
import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.customviews.LoadableView;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;
import com.teknasyon.relaxingsong.fragments.favourites.adapter.FavouriteListAdapter;
import com.teknasyon.relaxingsong.fragments.library.adapter.LibraryListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 13.10.2018.
 */


public class LibraryFragment extends BaseFragment implements LibraryContract.View{

    @BindView(R.id.rv_library_list)
    RecyclerView libraryRecyclerView;

    @BindView(R.id.lv_libraries)
    LoadableView librariesLoadableView;

    @Inject
    LibraryPresenter mPresenter;

    private LibraryListAdapter libraryListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_libraries, container, false);
        ButterKnife.bind(this, root);
        mPresenter.takeView(this);
        mPresenter.init();
        mPresenter.callLibrariesService();
        return root;
    }

    @Override
    public void showServerError(String errorMessage) {
        librariesLoadableView.showError(errorMessage);
    }

    @Override
    public void onInit() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        libraryListAdapter = new LibraryListAdapter(getContext(), null);
        libraryRecyclerView.setLayoutManager(linearLayoutManager);
        libraryRecyclerView.setAdapter(libraryListAdapter);
    }

    @Override
    public void onSuccessfulLibraryService(List<LibraryResponse> libraryResponseList) {
        librariesLoadableView.showContent();
        libraryListAdapter.setLibraryResponseList(libraryResponseList);
    }

    @Override
    public void showLoadingView() {
        librariesLoadableView.showLoading();
    }

    @Override
    public void onDestroy() {
        // to remove view from presenter
        mPresenter.dropView();
        super.onDestroy();
    }
}
