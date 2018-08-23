package com.example.howdo.myapplication.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.ui.fragment.NewsContentFragment;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_content);

        String newsTitle = getIntent().getStringExtra("news_title");
        String newsontent = getIntent().getStringExtra("news_content");

        NewsContentFragment fragmentById = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);
        fragmentById.refresh(newsTitle, newsontent);
    }
}
