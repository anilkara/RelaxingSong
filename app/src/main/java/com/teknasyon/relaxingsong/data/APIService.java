package com.teknasyon.relaxingsong.data;

import com.teknasyon.relaxingsong.data.model.LibraryResponse;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by anilkara on 13.10.2018.
 */

public interface APIService {

    @GET("ptfl4iydhk026qx/favourites.json?dl=0/")
    Observable<List<RelaxingSong>> getFavouriteList();

    @GET("f7x49jahgub0wwd/libraries.json?dl=0")
    Observable<List<LibraryResponse>> getLibraryList();

}
