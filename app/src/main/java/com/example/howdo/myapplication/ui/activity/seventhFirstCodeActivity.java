package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.ui.fragment.FirstCodeRightFragment;
import com.example.howdo.myapplication.ui.fragment.FirstCodeThirdFragment;

public class seventhFirstCodeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_first_code);

        Button viewById = (Button) findViewById(R.id.first_code_fragment_bt1);
        viewById.setOnClickListener(this);
        replaceFragment(new FirstCodeRightFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout_first,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_code_fragment_bt1:
                replaceFragment(new FirstCodeThirdFragment());
                break;
            default:
                break;
        }
    }
}
