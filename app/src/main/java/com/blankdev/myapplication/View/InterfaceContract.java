package com.blankdev.myapplication.View;

import com.blankdev.myapplication.Presenter.BasePresenter;

/**
 * Created by blankdev on 21/01/17.
 * Developer Android -> blankdev
 * Developer Web -> blankdev
 * Designer -> blankdev
 */

public interface InterfaceContract {
    interface View extends BaseView{
        void ErrorServer();
        void SuccessAccessServer();
    }

    interface Presenter extends BasePresenter{

    }
}
