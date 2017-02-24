package com.example.howdo.myapplication.ui.activity;

import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by howdo on 2016/12/8.
 */

public class CurrentSpeedActivity extends BaseActivity{
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;
    private int UPDATE = 100;
    private TextView spd;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO 接收消息并且去更新UI线程上的控件内容
            if (msg.what == UPDATE) {
                //tv.setText(String.valueOf(msg.obj));
                String spped_cur = String.valueOf(msg.obj);
                spd.setText(spped_cur);
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.speed;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        lastTotalRxBytes = getTotalRxBytes();
        lastTimeStamp = System.currentTimeMillis();
        spd = (TextView) findViewById(R.id.spd);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                showNetSpeed();
            }
        };
        new Timer().schedule(task, 1000, 2000); // 1s后启动任务，每2s执行一次
    }

    private void showNetSpeed() {
        long nowTotalRxBytes = getTotalRxBytes();
        long nowTimeStamp = System.currentTimeMillis();
        long speed = ((nowTotalRxBytes - lastTotalRxBytes) * 1000 / (nowTimeStamp - lastTimeStamp));//毫秒转换
        lastTimeStamp = nowTimeStamp;
        lastTotalRxBytes = nowTotalRxBytes;
        Message msg = mHandler.obtainMessage();
        msg.what = UPDATE;
        if(speed == 0){
            msg.obj = String.valueOf(speed) + ".00kb/s";
        }else {
            msg.obj = String.valueOf(speed) + "kb/s";
        }
        mHandler.sendMessage(msg);//更新界面
    }

    private long getTotalRxBytes() {
// return TrafficStats.getUidRxBytes(getApplicationInfo().uid) == TrafficStats.UNSUPPORTED ? 0 :(TrafficStats.getTotalRxBytes()/1024);//转为KB
        return TrafficStats.getTotalRxBytes()/1024;//转为KB
    }
}
