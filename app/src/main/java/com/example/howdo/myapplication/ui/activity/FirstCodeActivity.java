package com.example.howdo.myapplication.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import com.example.howdo.myapplication.util.ToastUtil;

import java.io.File;

import butterknife.BindView;

public class FirstCodeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.first_code_button1)
    Button FirstCodeButton1;
    @BindView(R.id.first_code_button2)
    Button FirstCodeButton2;
    @BindView(R.id.first_code_button3)
    Button FirstCodeButton3;
    @BindView(R.id.first_code_button5)
    Button FirstCodeButton4;
    @BindView(R.id.first_code_button6)
    Button LifeRecycle;
    @BindView(R.id.first_code_button7)
    Button FirstCodeButton7;
    @BindView(R.id.first_code_button8)
    Button FirstCodeButton8;
    @BindView(R.id.first_code_button9)
    Button FirstCodeButton9;
    @BindView(R.id.first_code_button10)
    Button FirstCodeButton10;
    @BindView(R.id.first_code_button11)
    Button FirstCodeButton11;
    @BindView(R.id.first_code_button12)
    Button FirstCodeButton12;
    @BindView(R.id.first_code_button13)
    Button FirstCodeButton13;
    @BindView(R.id.first_code_button14)
    Button FirstCodeButton14;
    @BindView(R.id.first_code_button15)
    Button FirstCodeButton15;
    @BindView(R.id.first_code_button16)
    Button FirstCodeButton16;
    @BindView(R.id.first_code_button17)
    Button FirstCodeButton17;

    private static final String TAG = "FirstCodeActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_first_code;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        FirstCodeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式Intent
                Intent intent = new Intent("com.example.howdo.myapplication.ui.activity.HtmlActivity.start");
                String data = "使用putExtra传值";
                intent.addCategory("com.example.MY_CATEGORY");
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });
        FirstCodeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        FirstCodeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        FirstCodeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, SecondFirstCodeActivity.class);
                startActivityForResult(intent, 24);
            }
        });
        LifeRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, ThirdFirstCodeActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, ForthFirstCodeActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, FifthFirstCodeActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, sixthFirstCodeActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, seventhFirstCodeActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, EighthFirstCodeActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, BroadCastReceiverDemoActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, FilePersistenceActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, SharedPreferenceActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this, ContentProviderActivity.class);
                startActivity(intent);
            }
        });
        FirstCodeButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCodeActivity.this,AboutMeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(FirstCodeActivity.this,0,intent,0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(FirstCodeActivity.this)
                        .setContentTitle("这是一个重要的通知")
                        .setContentText("尹东东发通知啦")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.icon2)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Aquila.ogg")))
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setLights(Color.GREEN,1000,1000)
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.android)))
                        .build();
                        manager.notify(1,notification);
            }
        });
    }

    //创建右上角菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_code_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first_code_main_menu:
                ToastUtil.showText("你点击了第一个");
                break;
            case R.id.first_code_second_menu:
                ToastUtil.showText("你点击了第二个");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 24:
                if (resultCode == RESULT_OK) {
                    String dataReturn = data.getStringExtra("data_return");
                    Log.d(TAG, "onActivityResult: " + dataReturn);
                }
                break;
            default:

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_code_button7:
                Log.d(TAG, "onClick: here");
                Intent intent = new Intent(FirstCodeActivity.this, ForthFirstCodeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
