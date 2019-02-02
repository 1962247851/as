package com.jn.mjz.activity.Clock;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jn.mjz.activity.R;

import java.util.concurrent.Delayed;

public class ClockViewActivity extends AppCompatActivity {

    private TextView mTvHour, mTvMinute, mTvSecond,mTvDay;
    private Button mBtnStart, mBtnPause, mBtnReset;
    Display day = new Display(0, 365);
    Display hour = new Display(0, 24);
    Display minute = new Display(0, 60);
    Display second = new Display(0, 60);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_view);
        mTvDay = findViewById(R.id.clock_tv_day);
        mTvHour = findViewById(R.id.clock_tv_hour);
        mTvMinute = findViewById(R.id.clock_tv_minute);
        mTvSecond = findViewById(R.id.clock_tv_second);
        mBtnStart = findViewById(R.id.ClockView_btn_start);
        mBtnPause = findViewById(R.id.ClockView_btn_pause);
        mBtnReset = findViewById(R.id.ClockView_btn_reset);
        setListeners();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handler.postDelayed(runnable,1000);
            mTvSecond.setText(second.increase().getValue());
            if (second.isMax()) {
                mTvMinute.setText(minute.increase().getValue());
                if (minute.isMax()) {
                    mTvHour.setText(hour.increase().getValue());
                }if(hour.isMax()){
                    mTvDay.setText(day.increase().getValue());
                }
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
        }
    };


    class onClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ClockView_btn_start:
                    handler.sendEmptyMessage(1);
                    break;
                case R.id.ClockView_btn_pause:
                    handler.sendEmptyMessage(2);
                    break;
                case R.id.ClockView_btn_reset:
                    hour.increase().

                            setValue(0);
                    minute.increase().

                            setValue(0);
                    second.increase().

                            setValue(0);
                    mTvHour.setText(hour.getValue());
                    mTvMinute.setText(minute.getValue());
                    mTvSecond.setText(second.getValue());
                    break;
            }
        }

    }

    void setListeners() {
        onClick onClick = new onClick();
        mBtnStart.setOnClickListener(onClick);
        mBtnReset.setOnClickListener(onClick);
        mBtnReset.setOnClickListener(onClick);
    }
}
