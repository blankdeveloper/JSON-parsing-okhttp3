package com.blankdev.myapplication.View;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blankdev.myapplication.Presenter.PresenterActivity;
import com.blankdev.myapplication.R;

public class MainActivity extends BaseActivity<PresenterActivity> {

    protected RecyclerView recyclerView;

    @Override
    protected int myView() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupView() {
        recyclerView = findById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected PresenterActivity onCreatePresenter() {
        return new PresenterActivity(this);
    }

    @Override
    protected void onBindPresenter(PresenterActivity presenter) {
        presenter.getDataServer();
        recyclerView.setAdapter(presenter.getAdapter());
    }
}
