package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivityForTest;
import com.example.howdo.myapplication.base.BaseFragmentForTest;
import com.example.howdo.myapplication.ui.fragment.BGARefreshSwipeListViewFragment;
import com.example.howdo.myapplication.ui.fragment.BGARefreshSwipeListViewFragment2;
import com.example.howdo.myapplication.ui.fragment.BGARefreshSwipeRecyclerViewFragment;
import com.example.howdo.myapplication.ui.fragment.MainTabFragment;
import com.example.howdo.myapplication.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainTabActivity extends BaseActivityForTest {
    public static boolean isFirst;

    private List<BaseFragmentForTest> fragments;
    MainTabFragment mainTabFragment;


    public void init() {
        mainTabFragment = (MainTabFragment) getSupportFragmentManager().findFragmentById(R.id.mainTabFragment);
        initFragments();
        if (isFirst) {
            MainTabFragment.setTabSelected(0);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerFL, fragments.get(0))
                    .commit();
        }
    }

    public void initFragments() {
        fragments = new ArrayList<BaseFragmentForTest>();

        BGARefreshSwipeListViewFragment searchFragment = new BGARefreshSwipeListViewFragment();
        BGARefreshSwipeRecyclerViewFragment bookFragment = new BGARefreshSwipeRecyclerViewFragment();
        BGARefreshSwipeListViewFragment2 anchorFragment = new BGARefreshSwipeListViewFragment2();

        fragments.add(searchFragment);
        fragments.add(bookFragment);
        fragments.add(anchorFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerFL, fragments.get(0), "f0")
                .add(R.id.fragmentContainerFL, fragments.get(1), "f1")
                .add(R.id.fragmentContainerFL, fragments.get(2), "f2")
                .commit();

        mainTabFragment.setOnTabClickListener(new MainTabFragment.OnTabClickListener() {
            @Override
            public void onClick(int position) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                for (int i = 0; i < fragments.size(); i++) {
                    transaction.hide(fragments.get(i));
                }
                transaction.show(fragments.get(position))
                        .commit();

            }
        });
        mainTabFragment.performClick(0);
    }

    @Override
    public void onBackPressed() {
        if (isFirst) {
            ToastUtil.showText("再按一次退出");
            isFirst = false;

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0);
                }
            }.start();
            return;
        }
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFirst = true;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main_tab);
        init();
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
}
