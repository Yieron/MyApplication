package com.example.howdo.myapplication.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.receiver.MyLocalBroadcastReceiver;
import com.example.howdo.myapplication.util.ToastUtil;

public class BroadCastReceiverDemoActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetWorkChangeReceiver netWorkChangeReceiver;
    private Button btnSendStandardBroadcast,btnSendOrderedBroadcast,btnSendLocalBroadcast;
    private LocalBroadcastManager localBroadcastManager;
    MyLocalBroadcastReceiver myLocalBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver_demo);
        btnSendStandardBroadcast = (Button) findViewById(R.id.btn_send_standard_broadcast);
        btnSendOrderedBroadcast = (Button) findViewById(R.id.btn_send_ordered_broadcast);
        btnSendLocalBroadcast = (Button) findViewById(R.id.btn_send_local_broadcast);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        intentFilter = new IntentFilter();
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netWorkChangeReceiver, intentFilter);

        btnSendStandardBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.howdo.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });

        btnSendOrderedBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.howdo.MY_ORDERED_BROADCAT");
                sendOrderedBroadcast(intent,null);
            }
        });

        btnSendLocalBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.howdo.MY_LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.howdo.MY_LOCAL_BROADCAST");
                myLocalBroadcastReceiver = new MyLocalBroadcastReceiver();
                localBroadcastManager.registerReceiver(myLocalBroadcastReceiver,intentFilter);
            }
        });
    }

    class NetWorkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (activeNetwork != null && activeNetwork.isAvailable()) {
                ToastUtil.showText("网络可用");
            } else {
                ToastUtil.showText("网络不可以用");
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver);
        localBroadcastManager.unregisterReceiver(myLocalBroadcastReceiver);
    }
}
