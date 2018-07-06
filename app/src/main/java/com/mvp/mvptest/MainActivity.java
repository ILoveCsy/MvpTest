package com.mvp.mvptest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.base.BaseMvpActivity;
import com.mvp.base.BasePresenter;
import com.mvp.presenter.WetherPresenter;
import com.mvp.view.IWetherView;

public class MainActivity extends BaseMvpActivity implements   View.OnClickListener ,IWetherView {
    private Button btn;
    private TextView textView;
    private ProgressDialog mDialog;
    private WetherPresenter mPresenter = new WetherPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //页面控件

    public void initView() {
        btn = (Button)findViewById(R.id.btn);
        textView = (TextView)findViewById(R.id.textview);

        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                mPresenter.requestWetherInfo();
                showToast(MainActivity.this,"click this");
                break;
        }
    }

    public void showToast(Context context,String str){
         Toast.makeText(context.getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInfoUpdate(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(info);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mDialog != null && mDialog.isShowing()){
                    mDialog.dismiss();
                }

                mDialog = ProgressDialog.show(MainActivity.this,"","正在获取中...");
            }
        });

    }

    @Override
    public void dissmissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mDialog != null && mDialog.isShowing()){
                    mDialog.dismiss();
                }
            }
        });

    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter;
    }
}
