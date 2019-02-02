package com.jn.mjz.activity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class ContainerActivity extends AppCompatActivity implements Fragment_a.IOnMessageClick {

    private Fragment_a fragment_a;
    private TextView mTvMessage,mTvMessage1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mTvMessage = findViewById(R.id.fragment_tv_message);
        mTvMessage1 = findViewById(R.id.fragment_tv_message1);
        //实例化fragment
        fragment_a = new Fragment_a();
        //将fragment添加到activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_fl, fragment_a,"a").commitAllowingStateLoss();
    }

    //可以,但不推荐
    public void setData(String string) {
        mTvMessage1.setText(string);
    }
    //回调接口,推荐
    @Override
    public void onClick(String string) {
        mTvMessage.setText(string);
    }
}
