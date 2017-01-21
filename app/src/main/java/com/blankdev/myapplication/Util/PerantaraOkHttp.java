package com.blankdev.myapplication.Util;

import android.content.Context;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by blankdev on 21/01/17.
 * Developer Android -> blankdev
 * Developer Web -> blankdev
 * Designer -> blankdev
 */

public class PerantaraOkHttp {
    private Request request;
    private OkHttpClient okhttp;
    private Context c;

    public PerantaraOkHttp(Context c) {
        this.c = c;
        okhttp = new OkHttpClient();
    }

    public PerantaraOkHttp url(String url){
        request = new Request.Builder()
                .url(url)
                .build();
        return this;
    }

    public PerantaraOkHttp mulai_pengambilan_data(Callback callback){
        okhttp.newCall(request).enqueue(callback);
        return this;
    }
}
