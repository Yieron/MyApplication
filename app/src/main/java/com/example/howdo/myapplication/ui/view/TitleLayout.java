package com.example.howdo.myapplication.ui.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.util.ToastUtil;

public class TitleLayout extends LinearLayout {
    private Button TitleButton1,TitleButton3;
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_first_code,this);
        TitleButton1 = (Button) findViewById(R.id.first_code_title_button1);
        TitleButton3 = (Button) findViewById(R.id.first_code_title_button3);

        TitleButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });


        TitleButton3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showText("点击了右侧的按钮！");
            }
        });
    }

}
