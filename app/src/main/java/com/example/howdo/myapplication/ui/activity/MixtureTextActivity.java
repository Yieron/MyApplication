package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.ui.view.MixtureTextView;

import butterknife.BindView;

/**
 * Created by howdo on 16/10/27.
 */

public class MixtureTextActivity extends BaseActivity {
    @BindView(R.id.id_mixtureTextview)
    MixtureTextView mixtureTextview;

    @Override
    protected int getLayoutId() {
        return R.layout.mixtrutextview;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mixturetextview,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_size_add:
                mixtureTextview.setTextSize(mixtureTextview.getTextSize()+2);
                break;
            case R.id.action_size_del:
                mixtureTextview.setTextSize(mixtureTextview.getTextSize()-2);
                break;
            case R.id.action_settings:
                Toast.makeText(this,"别按了，这没有处理",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_toggleText:
                String text = mixtureTextview.getText();
                if (text.equals(getString(R.string.text1))){
                    mixtureTextview.setText(getString(R.string.text2));
                }else {
                    mixtureTextview.setText(getString(R.string.text1));
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {

    }
}
