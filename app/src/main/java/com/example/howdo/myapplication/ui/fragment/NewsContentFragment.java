package com.example.howdo.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howdo.myapplication.R;

public class NewsContentFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_content, container, false);
        return view;
    }

    public void refresh(String newsTitle ,String newsContent){
        View visibilityLayout = view.findViewById(R.id.ll_visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView title = (TextView) view.findViewById(R.id.txt_fragment_news_title);
        TextView content = (TextView) view.findViewById(R.id.txt_fragment_news_content);
        title.setText(newsTitle);
        content.setText(newsContent);
    }

}
