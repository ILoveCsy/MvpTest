package com.mvp.view;

/**
 * Created by Administrator on 2018/7/5/005.
 */

public interface IWetherView {
    //设置数据  与  友好交互
    //更新UI（）
    public void onInfoUpdate(String info);
    //显示加载框
    public void showWaitingDialog();
    //关闭加载框
    public void dissmissWaitingDialog();
}
