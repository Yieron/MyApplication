package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.model.Fruit;
import com.example.howdo.myapplication.ui.adapter.FruitRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FifthFirstCodeActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_first_code);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.first_code_recycleView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecycleViewAdapter fruitRecycleViewAdapter = new FruitRecycleViewAdapter(fruitList);
        recyclerView.setAdapter(fruitRecycleViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Fruit apple = new Fruit(getRandomLength("Apple"), R.mipmap.bga_refresh_mt_refreshing_04);
            fruitList.add(apple);
            Fruit Orange = new Fruit(getRandomLength("Orange"), R.mipmap.bga_refresh_mt_refreshing_01);
            fruitList.add(Orange);
            Fruit pear = new Fruit(getRandomLength("pear"), R.mipmap.bga_refresh_mt_refreshing_02);
            fruitList.add(pear);
            Fruit peach = new Fruit(getRandomLength("peach"), R.mipmap.bga_refresh_mt_refreshing_03);
            fruitList.add(peach);
            Fruit apricot = new Fruit(getRandomLength("apricot"), R.mipmap.bga_refresh_mt_refreshing_05);
            fruitList.add(apricot);
            Fruit banana = new Fruit(getRandomLength("banana"), R.mipmap.ic_launcher);
            fruitList.add(banana);
        }

    }

    private String getRandomLength(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
