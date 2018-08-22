package com.example.howdo.myapplication.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.ui.fragment.NewsContentFragment;

public class EighthFirstCodeActivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context,EighthFirstCodeActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_first_code);

        String news_title = getIntent().getStringExtra("news_title");
        String news_content = getIntent().getStringExtra("news_content");

        NewsContentFragment fragmentById = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);
        fragmentById.refresh(news_title, news_content);
    }
}
