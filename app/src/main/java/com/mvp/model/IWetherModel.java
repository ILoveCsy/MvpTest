package com.mvp.model;

/**
 * Created by Administrator on 2018/7/5/005.
 */

public interface IWetherModel {
    //1.从Model中获取数据  2.将数据存到Model中
    //获取数据
    public String getInfo();

    //存储数据
    public void setInfo(String info);
}
