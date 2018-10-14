package com.teknasyon.relaxingsong.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anilkara on 14.10.2018.
 */

public class LibraryResponse {

    @SerializedName("categoryName")
    public String categoryName;

    @SerializedName("bacgroundUrl")
    public String backgroundUrl;

    @SerializedName("songs")
    public List<RelaxingSong> relaxingSongList;

}
