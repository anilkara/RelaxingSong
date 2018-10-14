package com.teknasyon.relaxingsong.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anilkara on 13.10.2018.
 */

public class RelaxingSong implements Serializable {

    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;
}
