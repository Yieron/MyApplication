package com.example.howdo.myapplication.ui.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    private Button sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        sharedPreference = (Button) findViewById(R.id.first_code_sharedPreference);
        sharedPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("dataSharedPreference",MODE_PRIVATE).edit();
                editor.putBoolean("married",true);
                editor.putInt("age",28);
                editor.putString("name","Yieron");
                editor.apply();
            }
        });
    }
}
