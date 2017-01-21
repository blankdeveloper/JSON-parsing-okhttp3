package com.blankdev.myapplication.Util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankdev.myapplication.Model.Data;
import com.blankdev.myapplication.R;
import com.blankdev.myapplication.View.InterfaceContract;

import java.util.List;

/**
 * Created by blankdev on 21/01/17.
 * Developer Android -> blankdev
 * Developer Web -> blankdev
 * Designer -> blankdev
 */

public class AdapterRecyclerView extends RecyclerView.Adapter<HolderRecyclerView> {
    private Context c;
    private List<Data> data;

    public AdapterRecyclerView(Context c, List<Data> data) {
        this.c = c;
        this.data = data;
    }

    @Override
    public HolderRecyclerView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.row_item,parent,false);
        return new HolderRecyclerView(v);
    }

    @Override
    public void onBindViewHolder(HolderRecyclerView holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
