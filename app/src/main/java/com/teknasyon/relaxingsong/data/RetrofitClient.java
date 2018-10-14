package com.teknasyon.relaxingsong.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anilkara on 13.10.2018.
 */

@Singleton
public class RetrofitClient {

    private Context context;

    @Inject
    public RetrofitClient(Context context){
        this.context = context;
    }

    private final static String BASE_URL = "https://dl.dropboxusercontent.com/s/ptfl4iydhk026qx/";

    private  Retrofit retrofit = null;
    private  APIService apiService = null;

    private void getClient(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
    }

    public APIService getRetrofitService(){

        if (retrofit == null){
            getClient(context);
        }

        if (retrofit != null && apiService == null) {
            apiService = retrofit.create(APIService.class);
        }

        return apiService;
    }

}
