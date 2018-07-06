package com.mvp.presenter;

import com.mvp.base.BasePresenter;
import com.mvp.model.IWetherModel;
import com.mvp.model.Wether;
import com.mvp.view.IWetherView;

/**
 * Created by Administrator on 2018/7/5/005.
 */

public class WetherPresenter extends BasePresenter {
    //1. 引入Model和View的接口
    IWetherModel mModel;
    IWetherView mView;

    public WetherPresenter(IWetherView view){
        //2. 注入View对象 与 创建Model对象
        this.mView = view;
        mModel = new Wether();
    }

    //供View层调用，用来请求天气数据
    public void requestWetherInfo(){
        getNetworkInfo();
    }

    private void showWaitingDialog(){
        if (mView != null) {
            mView.showWaitingDialog();
        }
    }

    private void dissmissWaitingDialog(){
        if (mView != null) {
            mView.dissmissWaitingDialog();
        }
    }

    private void updateWetherInfo(String info){
        if (mView != null) {
            mView.onInfoUpdate(info);
        }
    }
    //present 存入数据至  Model
    private void saveInfo(String info){
        mModel.setInfo(info);
    }
    //Model 为  present  提供数据
    private String localInfo(){
        return mModel.getInfo();
    }



    private void getNetworkInfo(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //打开等待对话框
                    showWaitingDialog();
                    //模拟网络耗时
                    Thread.sleep(3000);

                    String info = "21度，晴转多云";
                    //保存到Model层
                    saveInfo(info);
                    //从Model层获取数据，为了演示效果，实际开发中根据情况需要。
                    String localinfo = localInfo();

                    //通知View层改变视图
                    updateWetherInfo(localinfo);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //取消对话框
                    dissmissWaitingDialog();
                }
            }
        }).start();
    }

}
