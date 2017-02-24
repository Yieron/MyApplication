package com.example.howdo.myapplication.ui.activity;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;

import java.io.File;

import butterknife.BindView;

/**
 * Created by howdo on 2016/11/3.
 */

public class SDMountedActivity extends BaseActivity {
    @BindView(R.id.sd_capacity_remain)
    TextView sd_capacity_remain;

    @BindView(R.id.sd_capacity)
    TextView sd_capacity;

    @Override
    protected int getLayoutId() {
        return R.layout.sd_is_mounted;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        ExistSDCard();
        int sdAllSize = (int) getSDAllSize();
        int sdFreeSize = (int) getSDFreeSize();
        sd_capacity_remain.setText("本机SD卡剩余："+sdFreeSize+"M");
        sd_capacity.setText("本机SD卡总容量："+sdAllSize+"M");
    }

    /**
     * SD卡是否存在？
     *
     * @return
     */
    private boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }

    /**
     * SD卡剩余空间
     *
     * @return
     */
    public long getSDFreeSize() {
        //取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        //获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSize();
        //空闲的数据块的数量
        long freeBlocks = sf.getAvailableBlocks();
        //返回SD卡空闲大小
        //return freeBlocks * blockSize;  //单位Byte
        //return (freeBlocks * blockSize)/1024;  、//单位KB
        return (freeBlocks * blockSize) / 1024 / 1024; //单位MB
    }

    /**
     * SD卡总容量
     *
     * @return
     */
    public long getSDAllSize() {
        //取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        //获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSize();
        //获取所有数据块数
        long allBlocks = sf.getBlockCount();
        //返回SD卡大小
        //return allBlocks * blockSize; //单位Byte
        //return (allBlocks * blockSize)/1024; //单位KB
        return (allBlocks * blockSize) / 1024 / 1024; //单位MB
    }
}
