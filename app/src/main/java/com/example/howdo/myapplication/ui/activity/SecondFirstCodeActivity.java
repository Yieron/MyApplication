package com.example.howdo.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;

import butterknife.BindView;

public class SecondFirstCodeActivity extends BaseActivity {
    @BindView(R.id.first_code_button4)
    Button FirstCode4;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_first_code2;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        FirstCode4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","我是通过返回键返回的");
        setResult(RESULT_OK,intent);
        finish();
    }
}
