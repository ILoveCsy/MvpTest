package com.mvp.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/7/5/005.
 */

public abstract class BasePresenter<T> {
    protected Reference<T> viewRef;

    public void attachView(T view){
        viewRef= new WeakReference<T>(view);
    }

    public void detachView(){
        if(viewRef !=null){
            viewRef.clear();
            viewRef=null;
        }
    }
}
