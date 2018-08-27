package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;

import butterknife.BindView;

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
    }
}
