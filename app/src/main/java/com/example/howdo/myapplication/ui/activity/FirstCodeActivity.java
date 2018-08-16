package com.example.howdo.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.util.ToastUtil;

import butterknife.BindView;

public class FirstCodeActivity extends BaseActivity {
    @BindView(R.id.first_code_button1)
    Button FirstCodeButton1;

    @Override
    protected int getLayoutId() {
        return R.layout.first_code;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        FirstCodeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式Intent
                Intent intent = new Intent("com.example.howdo.myapplication.ui.activity.HtmlActivity.start");
                intent.addCategory("com.example.MY_CATEGORY");
                startActivity(intent);
            }
        });
    }

    //创建右上角菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_code_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first_code_main_menu:
                ToastUtil.showText("你点击了第一个");
                break;
            case R.id.first_code_second_menu:
                ToastUtil.showText("你点击了第二个");
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
