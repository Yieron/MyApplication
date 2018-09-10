package com.example.howdo.myapplication.httpCallback;

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
