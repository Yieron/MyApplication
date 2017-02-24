package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.util.NetSpeedUtil;

/**
 * Created by howdo on 2016/12/8.
 * 存在严重Bug，第一次正常，退出界面，再进来就不显示
 */

public class DownloadSpeedActivity extends BaseActivity {
    TextView text;
    NetSpeedUtil speed;
    Handler mHandler;

    @Override
    protected int getLayoutId() {
        return R.layout.speed;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        try {
            text = (TextView) findViewById(R.id.spd);
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // TODO 接收消息并且去更新UI线程上的控件内容
                    if (msg.what == 1) {
                        text.setText(String.valueOf(msg.arg1));
                    }
                    super.handleMessage(msg);
                }
            };

            speed = NetSpeedUtil.getInstant(this, mHandler);
            speed.startCalculateNetSpeed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speed.stopCalculateNetSpeed();
    }
}
