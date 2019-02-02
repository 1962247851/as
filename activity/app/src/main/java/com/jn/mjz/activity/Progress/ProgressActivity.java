package com.jn.mjz.activity.Progress;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSr;
    private ProgressBar mPb;
    private Button mBtn;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mSr = findViewById(R.id.progress_swipe_refresh);
        mPb = findViewById(R.id.progress_pb);
        mBtn = findViewById(R.id.progress_btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        mSr.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_dark,
                android.R.color.holo_green_dark);
        mSr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ToastUtil.showMsg(getApplicationContext(),"正在加载...");
                handler.sendEmptyMessage(0);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (mPb.getProgress() < 100) {
                handler.postDelayed(runnable, 20);
            } else {
                mSr.setRefreshing(false);
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
                mBtn.setText("开始加载...");
                mPb.setProgress(0);
                mPb.setSecondaryProgress(0);
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mBtn.setText("正在加载...");
            mPb.setProgress(mPb.getProgress() + 1);
            mPb.setSecondaryProgress(mPb.getProgress()*2);
            handler.sendEmptyMessage(0);
        }
    };
}
