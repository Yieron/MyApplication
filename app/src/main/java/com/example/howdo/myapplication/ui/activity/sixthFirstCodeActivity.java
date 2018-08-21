package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.model.Fruit;
import com.example.howdo.myapplication.model.Msg;
import com.example.howdo.myapplication.ui.adapter.msgRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class sixthFirstCodeActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private List<Msg> msgList = new ArrayList<>();
    private Button send;
    private EditText editText;
    private msgRecycleViewAdapter msgRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_first_code);
        initFruits();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recycleView = (RecyclerView) findViewById(R.id.first_code_recycleView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        send = (Button) findViewById(R.id.first_code_button_send);
        editText = (EditText) findViewById(R.id.first_code_editText1);
        msgRecycleViewAdapter = new msgRecycleViewAdapter(msgList);
        recycleView.setAdapter(msgRecycleViewAdapter);
        setSupportActionBar(toolbar);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                if (!"".equals(inputText)) {
                    Msg msg = new Msg(inputText,Msg.TYPE_SENT);
                    msgList.add(msg);
                    msgRecycleViewAdapter.notifyItemInserted(msgList.size() - 1); //当有消息时刷新RecycleView的显示
                    recycleView.scrollToPosition(msgList.size()-1);  //将RecycleView定位到最后一行
                    editText.setText("");//清空输入框的内容
                }
            }
        });
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
            Msg msg1 = new Msg("hello!", Msg.TYPE_RECEIVED);
            msgList.add(msg1);
            Msg msg2 = new Msg("YES,hello", Msg.TYPE_SENT);
            msgList.add(msg2);
            Msg msg3 = new Msg("who are you?", Msg.TYPE_RECEIVED);
            msgList.add(msg3);
            Msg msg4 = new Msg("hello!", Msg.TYPE_SENT);
            msgList.add(msg4);
        }

    }

}
