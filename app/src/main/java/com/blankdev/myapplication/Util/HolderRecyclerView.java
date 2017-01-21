package com.blankdev.myapplication.Util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankdev.myapplication.Model.Data;
import com.blankdev.myapplication.R;

/**
 * Created by blankdev on 21/01/17.
 * Developer Android -> blankdev
 * Developer Web -> blankdev
 * Designer -> blankdev
 */

public class HolderRecyclerView extends RecyclerView.ViewHolder {

    public TextView textView;

    public HolderRecyclerView(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.txt);
    }

    public void onBind(Data data){
        textView.setText(data.getNama());
    }
}
