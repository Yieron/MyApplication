package com.example.howdo.myapplication.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.engine.Engine;
import com.example.howdo.myapplication.misc.App;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Observable;

/**
 * Created by LMX on 2016/7/22.
 * <p/>
 * 抽象父类，子类不需要重写onCreate方法，需要实现getLayoutId方法，
 * 并在afterCreate方法中实现创建Activity之后的逻辑
 */
public abstract class BaseActivityForTest extends RxAppCompatActivity implements View.OnClickListener{
    public static List<BaseActivityForTest> activities = new ArrayList<>();
    private ProgressDialog dialog;

    //*************************以下为添加*****************************
    protected String TAG;
    protected App mApp;
    protected Engine mEngine;
    private SweetAlertDialog mLoadingDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //********************以下为添加********************
        TAG = this.getClass().getSimpleName();
        mApp = App.getInstance();
        mEngine = mApp.getEngine();
        initView(savedInstanceState);
        setListener();
        processLogic(savedInstanceState);
        //********************以上为添加*********************

        activities.add(this);

        ButterKnife.bind(this);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        /**
         * 在子类使用Observable中的compose操作符，调用，
         * 完成Observable发布的事件和当前的组件绑定，
         * 实现生命周期同步。从而实现当前组件生命周期结束时，自动取消对Observable订阅。
         */
        Observable.interval(1, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe();
    }

    //显示对话框，如果对话框没有显示，就显示出来
    public void showDialog() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    //传递消息的显示对话框
    public void showDialog(String msg) {
        dialog.setMessage(msg);
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    //隐藏对话框，如果对话框正在显示，就销毁
    public void hideDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    //销毁，将该界面从activities数组中移除
    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }

    //finish掉所有不是当前界面的界面
    public void clearOldActivity(BaseActivityForTest now) {
        for (BaseActivityForTest activity : activities) {
            if (activity != now) {
                activity.finish();
            }
        }
    }

    //finish所有界面
    public void clearAllActivity() {
        for (BaseActivityForTest activity : activities) {
            activity.finish();
        }
    }

    //**************************************************************

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) findViewById(id);
    }

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 给View控件添加事件监听器
     */
    protected abstract void setListener();

    /**
     * 处理业务逻辑，状态恢复等操作
     *
     * @param savedInstanceState
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    /**
     * 需要处理点击事件时，重写该方法
     *
     * @param v
     */
    public void onClick(View v) {
    }

    public void showLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new SweetAlertDialog(App.getInstance(), SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
            mLoadingDialog.setCancelable(false);
            mLoadingDialog.setTitleText("数据加载中...");
        }
        mLoadingDialog.show();
    }

    public void dismissLoadingDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }
}
