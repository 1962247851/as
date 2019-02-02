package com.jn.mjz.activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    private TextView mTv;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        mTv = findViewById(R.id.swipe_tv);
        final int  n = 0;
        swipeRefreshLayout=findViewById(R.id.swipe_container);
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_dark,
                android.R.color.holo_green_dark);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTv.setText("正在刷新");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        mTv.setText("下拉刷新");
                        Toast.makeText(SwipeRefreshLayoutActivity.this,"刷新完成",Toast.LENGTH_SHORT).show();
                    }
                },4000);
            }
        });
    }
}
