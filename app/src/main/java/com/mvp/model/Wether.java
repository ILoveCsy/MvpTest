package com.mvp.model;

/**
 * Created by Administrator on 2018/7/5/005.
 */

public class Wether implements IWetherModel {
    private String wetherinfo;
    @Override
    public String getInfo() {
        return wetherinfo;
    }

    @Override
    public void setInfo(String info) {
        this.wetherinfo =info;
    }
}
