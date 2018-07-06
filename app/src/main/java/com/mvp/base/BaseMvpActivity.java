package com.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2018/7/5/005.
 */

public abstract class BaseMvpActivity <V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected abstract T createPresenter();
}

