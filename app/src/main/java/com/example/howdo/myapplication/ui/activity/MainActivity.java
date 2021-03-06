package com.example.howdo.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.util.ToastUtil;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.functions.Action1;

/**
 * 此项目更多为学习测试练手之用，导入了很多nice的第三方库。
 * retrofit、RxJava、BufferKnife、OkHttp、Ion、Picasso
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.mix_text_pic)
    Button mix_text_pic;
    @BindView(R.id.html_demo)
    Button html_demo;
    @BindView(R.id.webview)
    Button webview;
    @BindView(R.id.sd_mounted)
    Button sd_mounted;
    @BindView(R.id.byeburgernavigation)
    Button byeburgernavigation;
    @BindView(R.id.BGARefreashLayout)
    Button BGARefreashLayout;
    @BindView(R.id.webview_bga)
    Button webview_bga;
    @BindView(R.id.main_tab)
    Button main_tab;
    @BindView(R.id.download_speed)
    Button downloadSpeed;
    @BindView(R.id.current_speed)
    Button currentSpeed;
    @BindView(R.id.layout_5)
    Button layout_5;
    @BindView(R.id.pinned)
    Button pinned;
    @BindView(R.id.dropDowmMenu)
    Button dropDowmMenu;
    @BindView(R.id.bajieDropDownMenu)
    Button bajieDropDownMenu;
    @BindView(R.id.open_camera_gallery)
    Button open_camera_gallery;
    @BindView(R.id.first_code)
    Button firstCode;
    @BindView(R.id.broadcast_force_offline)
    Button ForceOffline;
    @BindView(R.id.baidu_location)
    Button baiduMap;

    private DrawerLayout drawerLayout;
    private static final String TAG = "MainActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.about_me:
                startActivity(new Intent(MainActivity.this, AboutMeActivity.class));
                break;
            case R.id.me:
                ToastUtil.showText("我最帅");
                break;
            case R.id.my_dear:
                ToastUtil.showText("大美女");
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }

        return true;
    }

    private void initData() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.first_code_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.bga_refresh_mt_refreshing_05);
        }

        repalceDemo();
        navigationView.setCheckedItem(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.nav_yuli:
                        ToastUtil.showText("yully");
                        break;
                    case R.id.nav_yindong:
                        ToastUtil.showText("yindong");
                        break;
                    case R.id.nav_yieron:
                        ToastUtil.showText("yieron");
                        break;
                    case R.id.nav_yully:
                        ToastUtil.showText("yully");
                        break;
                    default:
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        RxView.clicks(mix_text_pic)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, MixtureTextActivity.class));
                    }
                });

        RxView.clicks(html_demo)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, HtmlActivity.class));
                    }
                });

        RxView.clicks(webview)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, NormalWebViewActivity.class));
                    }
                });

        RxView.clicks(sd_mounted)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, SDMountedActivity.class));
                    }
                });

        RxView.clicks(byeburgernavigation)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, ByeBurgerNavigationView.class));
                    }
                });

        RxView.clicks(BGARefreashLayout)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, BGASwipeListViewActivity.class));
                    }
                });

        RxView.clicks(webview_bga)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, BGAWebViewActivity.class));
                    }
                });

        RxView.clicks(main_tab)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, MainTabActivity.class));
                    }
                });

        RxView.clicks(downloadSpeed)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, DownloadSpeedActivity.class));
                    }
                });

        RxView.clicks(currentSpeed)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, CurrentSpeedActivity.class));
                    }
                });

        RxView.clicks(layout_5)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, DesignSupportLibraryActivity.class));
                    }
                });

        RxView.clicks(pinned)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, PinnedSectionListActivity.class));
                    }
                });

        RxView.clicks(dropDowmMenu)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, DropDownMenuActivity.class));
                    }
                });
        RxView.clicks(bajieDropDownMenu)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, DropDownMenu2Activity.class));
                    }
                });

        RxView.clicks(open_camera_gallery)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, OpenGalleryAndCameraActivity.class));
                    }
                });

        RxView.clicks(firstCode)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, FirstCodeActivity.class));
                    }
                });
        RxView.clicks(ForceOffline)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Intent intent = new Intent("com.example.howdo.FORCE_OFFLINE");
                        sendBroadcast(intent);
                    }
                });

        RxView.clicks(baiduMap)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, BaiduMapActivity.class));
                    }
                });
    }

    /**
     * replace类使用解释说明demo
     */
    private void repalceDemo() {
        String text = "";
        String data = "大家好我是尹东 你好！安卓，你好！";
        text = data.replace("大家好我是尹东", "尹东");
        Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 150);
        toast.show();
    }
}
