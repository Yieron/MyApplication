package com.example.howdo.myapplication.util;

import android.util.Log;

public class LogUtil {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;

    public static int level = VERBOSE;  //平常开发置为NOTHING ，上线置为VERBOSE

    public static void v(String tag, String msg) {
        if (level <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (level <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String name) {
        if (level <= INFO) {
            Log.i(tag, name);
        }
    }

    public static void w(String tag, String name) {
        if (level <= WARN) {
            Log.w(tag, name);
        }
    }

    public static void e(String tag, String name) {
        if (level <= ERROR) {
            Log.e(tag, name);
        }
    }
}
