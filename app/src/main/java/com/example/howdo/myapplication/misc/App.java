package com.example.howdo.myapplication.misc;

import android.app.Application;
import android.content.Context;

import com.example.howdo.myapplication.engine.Engine;

import org.litepal.LitePal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/6/21 下午10:13
 * 描述:
 */
public class App extends Application {
    public static App sInstance;
    public Engine mEngine;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        sInstance = this;
        context = getApplicationContext();

        mEngine = new Retrofit.Builder()
                .baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);

    }

    public static App getInstance() {
        return sInstance;
    }

    public Engine getEngine() {
        return mEngine;
    }

    public static Context getContext() {
        return context;
    }
}