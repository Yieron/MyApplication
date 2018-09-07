package com.example.howdo.myapplication.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.util.ToastUtil;

import java.io.File;

public class VideoViewActivity extends AppCompatActivity implements View.OnClickListener {
    private Button videoPlay, videoPause, videoResume;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoPlay = (Button) findViewById(R.id.first_code_video_play);
        videoPause = (Button) findViewById(R.id.first_code_video_pause);
        videoResume = (Button) findViewById(R.id.first_code_video_resume);
        videoView = (VideoView) findViewById(R.id.first_code_video_view);

        videoPlay.setOnClickListener(this);
        videoPause.setOnClickListener(this);
        videoResume.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(VideoViewActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(VideoViewActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initVideoPath();
        }
    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory()+"/netease/cloudmusic/MV/", "群星 - 北京欢迎你.mp4");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_code_video_play:
                if (!videoView.isPlaying()) {

                    videoView.start();
                }
                break;
            case R.id.first_code_video_pause:
                if (videoView.isPlaying()) {

                    videoView.pause();
                }
                break;
            case R.id.first_code_video_resume:
                if (videoView.isPlaying()) {

                    videoView.resume();
                }
                break;

            default:
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideoPath();
                } else {
                    ToastUtil.showText("拒绝就退出该界面");
                    finish();
                }
                break;
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}
