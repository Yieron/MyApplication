package com.example.howdo.myapplication.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.ui.activity.ServiceDemoActivity;

public class MyService extends Service {
    public class DownloadBinder extends Binder {
        public void startDownload() {

        }

        public int getProgress() {
            return 0;
        }
    }

    private DownloadBinder mBinder = new DownloadBinder();
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//      throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        //使用前台服务
        Intent intent = new Intent(this, ServiceDemoActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("这是服务通知")
                .setContentText("服务突突突突突突拖")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.android)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.icon2))
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

        //service是在主线程中运行的，耗时操作都要在子线程中运行，避免出现ANR
        new Thread(new Runnable() {
            @Override
            public void run() {
                //...

                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


}
