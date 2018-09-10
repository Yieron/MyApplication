package com.example.howdo.myapplication.ui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.service.MyIntentService;
import com.example.howdo.myapplication.service.MyService;

public class ServiceDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int UPDATE_TEXT = 1;
    private Button btnHandler, btnAsyncTask, startService, stopService,bindService,unbindService,startIntentService,startDownload,pauseDownload,cancelDownload;
    private TextView firstCodeTxt;
    private static final String TAG = "ServiceDemoActivity";
    private MyService.DownloadBinder downloadBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);

        btnHandler = (Button) findViewById(R.id.first_code_handler);
        btnAsyncTask = (Button) findViewById(R.id.first_code_AsyncTask);
        startService = (Button) findViewById(R.id.first_code_start_service);
        stopService = (Button) findViewById(R.id.first_code_stop_service);

        bindService = (Button) findViewById(R.id.first_code_bind_service);
        unbindService = (Button) findViewById(R.id.first_code_unbind_service);
        startIntentService = (Button) findViewById(R.id.first_code_start_intent_service);

        startDownload = (Button) findViewById(R.id.first_code_start_download);
        pauseDownload = (Button) findViewById(R.id.first_code_pause_download);
        cancelDownload = (Button) findViewById(R.id.first_code_start_cancel_download);

        firstCodeTxt = (TextView) findViewById(R.id.first_code_txt1);
        btnHandler.setOnClickListener(this);
        btnAsyncTask.setOnClickListener(this);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        startIntentService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        startDownload.setOnClickListener(this);
        pauseDownload.setOnClickListener(this);
        cancelDownload.setOnClickListener(this);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    Log.d(TAG, "handleMessage: 111");
                    firstCodeTxt.setText("YIERON");
                    break;
                default:
                    break;
            }
        }
    };

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_code_handler:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.first_code_AsyncTask:
                break;
            case R.id.first_code_start_service:
                Intent startIntent=new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.first_code_stop_service:
                Intent stopService  = new Intent(this,MyService.class);
                stopService(stopService);
                break;
            case R.id.first_code_bind_service:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.first_code_unbind_service:
                unbindService(connection);
                break;
            case R.id.first_code_start_intent_service:
                Log.d(TAG, "onClick: Thred is = "+Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
            case R.id.first_code_start_download:

                break;
            case R.id.first_code_pause_download:

                break;
            case R.id.first_code_start_cancel_download:

                break;
            default:
                break;

        }
    }
}
