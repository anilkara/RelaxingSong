package com.teknasyon.relaxingsong.fragments.library;

import com.teknasyon.relaxingsong.data.model.RelaxingSong;

import java.util.List;

/**
 * Created by anilkara on 14.10.2018.
 */

public interface OnLibraryAdapterListener {
    void onItemClicked(List<RelaxingSong> relaxingSongList);
}
