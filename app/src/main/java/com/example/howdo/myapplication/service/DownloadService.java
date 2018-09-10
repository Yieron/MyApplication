package com.example.howdo.myapplication.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.http.DownloadListener;
import com.example.howdo.myapplication.ui.activity.ServiceDemoActivity;
import com.example.howdo.myapplication.util.ToastUtil;

public class DownloadService extends Service {
    private DownloadTask downloadTask;
    private String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManage().notify(1, getNotification("Downloading....", progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            stopForeground(true);

            getNotificationManage().notify(1, getNotification("Download Success", -1));
            ToastUtil.showText("Download Successed!");
        }

        @Override
        public void onFailed() {
            downloadTask = null;

            stopForeground(true);
            getNotificationManage().notify(1, getNotification("Download Failed", -1));
            ToastUtil.showText("Download failed");
        }

        @Override
        public void onPaused() {
            downloadTask = null;
            ToastUtil.showText("pause");
        }

        @Override
        public void onCanceled() {
            downloadTask=null;
            stopForeground(true);
            ToastUtil.showText("Canceled");
        }
    };

    public DownloadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    class DownloadBinder extends Binder{
        public void startDownload(String url){

        }
    }

    private NotificationManager getNotificationManage() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNotification(String title, int progress) {
        Intent intent = new Intent(this, ServiceDemoActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.icon2);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.android));
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle(title);
        if (progress >= 0) {
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }

        return builder.build();
    }
}
