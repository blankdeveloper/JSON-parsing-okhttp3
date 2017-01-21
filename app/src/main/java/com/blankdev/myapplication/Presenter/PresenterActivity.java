package com.blankdev.myapplication.Presenter;

import android.content.Context;
import android.os.Looper;

import com.blankdev.myapplication.Model.Data;
import com.blankdev.myapplication.Util.AdapterRecyclerView;
import com.blankdev.myapplication.Util.PerantaraOkHttp;
import com.blankdev.myapplication.Util.URL;
import com.blankdev.myapplication.View.InterfaceContract;
import com.blankdev.rchelper.Rchelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by blankdev on 21/01/17.
 * Developer Android -> blankdev
 * Developer Web -> blankdev
 * Designer -> blankdev
 */

public final class PresenterActivity implements InterfaceContract.Presenter {

    private InterfaceContract.View view;
    private List<Data> data;

    public PresenterActivity(InterfaceContract.View view) {
        this.view = view;
    }

    public void getDataServer(){
        data = new ArrayList<>();

        new PerantaraOkHttp((Context) view)
                .url(URL.url)
                .mulai_pengambilan_data(new Callback() {
                    @Override
                    public void onFailure(Call call, final IOException e) {
                        Looper.prepare();
                        Rchelper.pre("Pesan Request : "+e.getMessage());
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Looper.prepare();
                        if(!response.isSuccessful()){
                            new IOException("error code");
                        }

                        final String responData = response.body().string();

                        try {
                            JSONObject jsonObject = new JSONObject(responData);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for(int i = 0;i < jsonArray.length();i++){
                                JSONObject a = jsonArray.getJSONObject(i);
                                Data x = new Data();
                                x.setNama(a.getString("bank"));
                                data.add(x);
                            }
                            Rchelper.pre("total data : "+data.size());
                        } catch (JSONException e) {
                            Rchelper.pre("error parsing : "+e.getMessage());
                            e.printStackTrace();
                        }
                        Looper.loop();
                    }
                });
    }

    public AdapterRecyclerView getAdapter(){
        return new AdapterRecyclerView((Context) view,data);
    }


}
