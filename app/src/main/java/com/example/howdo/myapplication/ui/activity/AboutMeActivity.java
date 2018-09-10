package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.http.HttpRequest;
import com.example.howdo.myapplication.httpCallback.HttpCallbackListener;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by howdo on 2016/11/3.
 */

public class AboutMeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contact)
    FloatingActionButton floatingActionButton;

    @Override
    protected int getLayoutId() {
        return R.layout.collapsing_toolbar;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        //给页面设置工具栏
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置工具栏标题
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("尹东");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllActivity();
            }
        });

        String address = "http://www.baidu.com";
        HttpRequest.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {

            }

            @Override
            public void onError(Exception e) {

            }
        });


        HttpRequest.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
            }
        });
    }
}
