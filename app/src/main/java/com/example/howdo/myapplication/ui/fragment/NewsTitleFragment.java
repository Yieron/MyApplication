package com.example.howdo.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.model.FragmentDemoNews;
import com.example.howdo.myapplication.ui.activity.NewsContentActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_title, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_news_title);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<FragmentDemoNews> getNews() {
        List<FragmentDemoNews> fragmentDemoNews = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            FragmentDemoNews news  =  new FragmentDemoNews();
            news.setTitle("This is news title"+i);
            news.setContent(getRandomLengthContent("this is news content"+i+""));
            fragmentDemoNews.add(news);
        }
        return fragmentDemoNews;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<length;i++){
            builder.append(content);
        }

        return builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity().findViewById(R.id.fragment_news_content) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<FragmentDemoNews> mNewsList;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_title, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentDemoNews fragmentDemoNews = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.fragment_news_content);
                        newsContentFragment.refresh(fragmentDemoNews.getTitle(), fragmentDemoNews.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), fragmentDemoNews.getTitle(), fragmentDemoNews.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            FragmentDemoNews fragmentDemoNews = mNewsList.get(position);
            holder.title.setText(fragmentDemoNews.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;

            public ViewHolder(View view) {
                super(view);

                title = (TextView) view.findViewById(R.id.txt_item_news_title);
            }
        }

        public NewsAdapter(List<FragmentDemoNews> newsList) {
            mNewsList = newsList;
        }
    }
}
