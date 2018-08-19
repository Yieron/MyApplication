package com.example.howdo.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.model.Fruit;
import com.example.howdo.myapplication.ui.adapter.FruitAdapter;
import com.example.howdo.myapplication.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ForthFirstCodeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ForthFirstCodeActivity";
    private Button FirstCodeButtonBar1, FirstCodeButtonBar2;
    private ProgressBar FirstCodeProgressBar1;
    private ListView ContentListView;
    private String[] dataSource = {"Apple", "Orange", "pear", "peach", "apricot", "banana", "Apple",
            "Orange", "pear", "peach", "apricot", "banana", "Apple", "Orange", "pear", "peach", "apricot", "banana"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_first_code);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FirstCodeButtonBar1 = (Button) findViewById(R.id.first_code_forth_button1);
        FirstCodeButtonBar2 = (Button) findViewById(R.id.first_code_forth_button2);
        FirstCodeProgressBar1 = (ProgressBar) findViewById(R.id.first_code_progress_1);

        initFruits();
        ContentListView = (ListView) findViewById(R.id.content_forth_lv1);
//        ContentListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSource));
        FruitAdapter fruitAdapter = new FruitAdapter(ForthFirstCodeActivity.this, R.layout.item_fruit, fruitList);
        ContentListView.setAdapter(fruitAdapter);
        ContentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                ToastUtil.showText(fruit.getName() + fruit.getImageId());
            }
        });
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FirstCodeButtonBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirstCodeProgressBar1.getVisibility() == View.GONE) {
                    FirstCodeProgressBar1.setVisibility(View.VISIBLE);
                } else {
                    FirstCodeProgressBar1.setVisibility(View.GONE);
                }
            }
        });

        FirstCodeButtonBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ForthFirstCodeActivity.this);
                progressDialog.setTitle("加载");
                progressDialog.setMessage("loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();

            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Fruit apple = new Fruit("Apple", R.mipmap.bga_refresh_mt_refreshing_04);
            fruitList.add(apple);
            Fruit Orange = new Fruit("Orange", R.mipmap.bga_refresh_mt_refreshing_01);
            fruitList.add(Orange);
            Fruit pear = new Fruit("pear", R.mipmap.bga_refresh_mt_refreshing_02);
            fruitList.add(pear);
            Fruit peach = new Fruit("peach", R.mipmap.bga_refresh_mt_refreshing_03);
            fruitList.add(peach);
            Fruit apricot = new Fruit("apricot", R.mipmap.bga_refresh_mt_refreshing_05);
            fruitList.add(apricot);
            Fruit banana = new Fruit("banana", R.mipmap.ic_launcher);
            fruitList.add(banana);
        }

    }


    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: v" + v);
        Log.d(TAG, "onClick: v.getId()" + v.getId());
        switch (v.getId()) {
            case R.id.first_code_forth_button1:
                Log.d(TAG, "onClick: here!");
                if (FirstCodeProgressBar1.getVisibility() == View.GONE) {
                    FirstCodeProgressBar1.setVisibility(View.VISIBLE);
                } else {
                    FirstCodeProgressBar1.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}
