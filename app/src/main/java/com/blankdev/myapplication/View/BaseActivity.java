package com.blankdev.myapplication.View;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by blankdev on 21/01/17.
 * Developer Android -> blankdev
 * Developer Web -> blankdev
 * Designer -> blankdev
 */

public abstract class BaseActivity<Presenter> extends AppCompatActivity implements InterfaceContract.View {

    protected Context c;
    protected Bundle savedInstanceState;
    protected Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(myView());

        c = this;
        this.savedInstanceState = savedInstanceState;

        presenter = onCreatePresenter();

        setupView();

        onBindPresenter(presenter);
    }

    protected abstract int myView();

    protected abstract void setupView();

    protected abstract Presenter onCreatePresenter();

    protected abstract void onBindPresenter(Presenter presenter);

    protected <T extends View> T findById(int id) {
        return (T) findViewById(id);
    }

    @Override
    public void ErrorServer() {
        Toast.makeText(c, "Server Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SuccessAccessServer() {
        Toast.makeText(c, "Server success", Toast.LENGTH_SHORT).show();
    }
}
