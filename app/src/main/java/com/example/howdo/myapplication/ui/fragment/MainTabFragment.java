package com.example.howdo.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.misc.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMX on 2016/7/22.
 */
public class MainTabFragment extends Fragment implements View.OnClickListener {

    private static final int[] drawablesSelected = new int[]{
            R.mipmap.ic_main_tab01_selected,
            R.mipmap.ic_main_tab02_selected,
            R.mipmap.ic_main_tab03_selected,
    };

    private static final int[] drawablesNotSelected = new int[]{
            R.mipmap.ic_main_no_tab01,
            R.mipmap.ic_main_no_tab02,
            R.mipmap.ic_main_no_tab03,
    };


    private static List<LinearLayout> tabList;

    private LinearLayout tabOneLL;
    private LinearLayout tabTwoLL;
    private LinearLayout tabThreeLL;

    private OnTabClickListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_tab, null);

        tabOneLL = (LinearLayout) view.findViewById(R.id.tabOneLL);
        tabTwoLL = (LinearLayout) view.findViewById(R.id.tabTwoLL);
        tabThreeLL = (LinearLayout) view.findViewById(R.id.tabThreeLL);

        tabList = new ArrayList<LinearLayout>();
        tabList.add(tabOneLL);
        tabList.add(tabTwoLL);
        tabList.add(tabThreeLL);

        tabOneLL.setOnClickListener(this);
        tabTwoLL.setOnClickListener(this);
        tabThreeLL.setOnClickListener(this);

        setTabSelected(0);

        return view;
    }

    public void setOnTabClickListener(OnTabClickListener listener) {
        mListener = listener;
    }


    public void performClick(int postion) {
        tabList.get(postion).performClick();
    }

    @Override
    public void onClick(View v) {
        int position = -1;

        switch (v.getId()) {
            case R.id.tabOneLL:
                position = 0;
                break;
            case R.id.tabTwoLL:
                position = 1;
                break;
            case R.id.tabThreeLL:
                position = 2;
                break;
        }

        setTabSelected(position);

        if (position != -1 && mListener != null) {
            mListener.onClick(position);
        }
    }


    public static void setTabSelected(int position) {

        if (position == -1) {
            return;
        }

        ImageView imageView = null;
        TextView textView = null;

        for (int i = 0; i < tabList.size(); i++) {
            LinearLayout tabTemp = tabList.get(i);
            imageView = (ImageView) tabTemp.findViewWithTag("image");
            textView = (TextView) tabTemp.findViewWithTag("text");

            if (position == i) {
                imageView.setImageResource(drawablesSelected[i]);
                textView.setTextColor(App.getInstance().getResources().getColor(R.color.text_tab_selected));
            } else {
                imageView.setImageResource(drawablesNotSelected[i]);
                textView.setTextColor(App.getInstance().getResources().getColor(R.color.text_tab_no));
            }
        }
    }

    public interface OnTabClickListener {
        /**
         * @param position the position of selected tab (begin with 0)
         */
        void onClick(int position);
    }
}
