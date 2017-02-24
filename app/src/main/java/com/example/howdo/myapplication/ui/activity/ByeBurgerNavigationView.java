package com.example.howdo.myapplication.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.ui.fragment.HolderFragment;
import com.example.howdo.myapplication.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by howdo on 2016/11/5.
 */

public class ByeBurgerNavigationView extends BaseActivity {
    RecyclerView mRecyclerView;
    ViewPager mViewPager;
    List<Fragment> fragmentList;
    BottomNavigationView mByeBurger;

    @Override
    protected int getLayoutId() {
        return R.layout.byeburgernavigationview;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        initData();
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("ByeBurger");
        setSupportActionBar(toolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mByeBurger = (BottomNavigationView) findViewById(R.id.bye_burger);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override public int getCount() {
                return fragmentList.size();
            }
        });


        mByeBurger.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if(item.getTitle().equals("home")){
                            mViewPager.setCurrentItem(0);
                        }else if(item.getTitle().equals("search")){
                            mViewPager.setCurrentItem(1);
                        }else if(item.getTitle().equals("me")){
                            mViewPager.setCurrentItem(2);
                        }else if(item.getTitle().equals("setting")){
                            mViewPager.setCurrentItem(3);
                        }
                        return false;
                    }
                });

    }
    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance());

        fragmentList.add(HolderFragment.newInstance("search"));

        fragmentList.add(HolderFragment.newInstance("me"));

        fragmentList.add(HolderFragment.newInstance("setting"));
    }
}
