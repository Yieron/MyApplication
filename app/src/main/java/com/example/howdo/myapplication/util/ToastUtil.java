package com.example.howdo.myapplication.util;

import android.widget.Toast;

import com.example.howdo.myapplication.misc.App;

/**
 * Created by howdo on 16/10/28.
 */

public class ToastUtil {
    public static void showText(String text) {
        if (text.length() < 10) {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }
}
