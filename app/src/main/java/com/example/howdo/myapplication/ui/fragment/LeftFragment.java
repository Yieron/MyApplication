package com.example.howdo.myapplication.ui.fragment;

import android.os.Bundle;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseFragmentForTest;

/**
 * Created by howdo on 2016/11/9.
 */

public class LeftFragment extends BaseFragmentForTest {
    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.about_me);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
}
