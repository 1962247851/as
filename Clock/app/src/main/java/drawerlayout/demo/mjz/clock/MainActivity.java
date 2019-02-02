package drawerlayout.demo.mjz.clock;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText mEt;
    private TextView mTvHour, mTvMinute, mTvSecond, mTvDay;
    private Button mBtnStart, mBtnReset, mBtnGaoji, mBtnQueding, mBtnSwitch;
    private int delayMillis = 1000;
    private int choicedId = 0;
    private Boolean direction = true, isGonging = false;//direction true时正计时
    Display day = new Display(0, 365);
    Display hour = new Display(0, 24);
    Display minute = new Display(0, 60);
    Display second = new Display(0, 60);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEt = findViewById(R.id.mEt);
        mTvDay = findViewById(R.id.clock_tv_day);
        mTvHour = findViewById(R.id.clock_tv_hour);
        mTvMinute = findViewById(R.id.clock_tv_minute);
        mTvSecond = findViewById(R.id.clock_tv_second);
        mBtnStart = findViewById(R.id.ClockView_btn_start);
        mBtnReset = findViewById(R.id.ClockView_btn_reset);
        mBtnGaoji = findViewById(R.id.btn_gaoji);
        mBtnQueding = findViewById(R.id.btn_queding);
        mBtnSwitch = findViewById(R.id.btn_switch);
        AlertDialog dialog;
        dialog = new AlertDialog.Builder(MainActivity.this).setTitle("提示:").setMessage("暂停功能有Bug想解决方法中...\n点击数字可设置起点").setCancelable(false).setPositiveButton("知道了", null).create();
        dialog.show();
        setListeners();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!direction && mTvDay.getText().toString().equals("0") && mTvHour.getText().toString().equals("0") && mTvMinute.getText().toString().equals("0") && mTvSecond.getText().toString().equals("0")) {
                Toast.makeText(MainActivity.this, "倒计时结束", Toast.LENGTH_SHORT).show();
                mBtnStart.setText("开始计时");
                handler.removeCallbacks(runnable);
            } else {
                if (direction) {
                    if (msg != null && msg.what == 1) {
                        mTvSecond.setText(second.increase().getValue());
                        if (second.isLimited()) {
                            mTvMinute.setText(minute.increase().getValue());
                            if (minute.isLimited()) {
                                mTvHour.setText(hour.increase().getValue());
                                if (hour.isLimited()) {
                                    mTvDay.setText(day.increase().getValue());
                                }
                            }
                        }
                        handler.postDelayed(runnable, delayMillis);
                    }
                } else {
                    if (msg != null && msg.what == 1) {
                        mTvSecond.setText(second.decrease().getValue());
                        if (second.isLimited()) {
                            mTvMinute.setText(minute.decrease().getValue());
                            if (minute.isLimited()) {
                                mTvHour.setText(hour.decrease().getValue());
                                if (hour.isLimited()) {
                                    mTvDay.setText(day.decrease().getValue());
                                }
                            }
                        }
                        handler.postDelayed(runnable, delayMillis);
                    }
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
                    if (mBtnStart.getText().toString().equals("开始计时")) {
                        handler.sendEmptyMessageDelayed(1, delayMillis);
                        mBtnStart.setText("暂停计时");
                    } else if (mBtnStart.getText().toString().equals("暂停计时")) {
                        isGonging = false;
                        mBtnStart.setText("继续计时");
                        handler.removeCallbacks(runnable);
                    } else if (mBtnStart.getText().toString().equals("继续计时")) {
                        mBtnStart.setText("暂停计时");
                        isGonging = true;
                        handler.post(runnable);
                    }
                    break;
                case R.id.ClockView_btn_reset:
                    handler.removeCallbacks(runnable);
                    handler.removeMessages(1);
                    day.setValue(0);
                    hour.setValue(0);
                    minute.setValue(0);
                    second.setValue(0);
                    mTvDay.setText(day.getValue());
                    mTvHour.setText(hour.getValue());
                    mTvMinute.setText(minute.getValue());
                    mTvSecond.setText(second.getValue());
                    isGonging = true;
                    mBtnStart.setText("开始计时");
                    break;
                case R.id.btn_gaoji:
                    final String[] sex = {"1000ms", "100ms", "10ms", "1ms"};
                    //生成对话框
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("选择延时执行的间隔:")
                            .setSingleChoiceItems(sex, choicedId,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case 0:
                                                    delayMillis = 1000;
                                                    choicedId = 0;
                                                    break;
                                                case 1:
                                                    delayMillis = 100;
                                                    choicedId = 1;
                                                    break;
                                                case 2:
                                                    delayMillis = 10;
                                                    choicedId = 2;
                                                    break;
                                                case 3:
                                                    delayMillis = 1;
                                                    choicedId = 3;
                                                    break;
                                            }
                                            Toast.makeText(MainActivity.this, "间隔设置为" + delayMillis + "ms", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    }
                            )
                            .show();
                    break;
                case R.id.btn_switch:
                    if (mBtnSwitch.getText().toString().equals("正向计时")) {
                        direction = false;
                        isGonging = true;
                        mBtnSwitch.setText("逆向计时");
                        Toast.makeText(MainActivity.this, "当前模式：负计时", Toast.LENGTH_SHORT).show();
                    } else if (mBtnSwitch.getText().toString().equals("逆向计时")) {
                        direction = true;
                        mBtnSwitch.setText("正向计时");
                        Toast.makeText(MainActivity.this, "当前模式：正计时", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_queding:
                    String string = mEt.getText().toString();
                    if (string.equals("")) {
                        Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        delayMillis = Integer.parseInt(string);
                        Toast.makeText(MainActivity.this, "间隔设置为" + delayMillis + "ms", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.clock_tv_day:
                    final InputDialog inputDialog = new InputDialog(MainActivity.this);
                    inputDialog.setClick(new InputDialog.IOnClickLitener() {
                        @Override
                        public void onClick(InputDialog inputDialog) {
                            String s = inputDialog.getString();
                            if (!s.equals("")) {
                                if (Integer.parseInt(s) >= 365 && direction) {
                                    Toast.makeText(MainActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                                }else {
                                    mTvDay.setText(s);
                                    Toast.makeText(MainActivity.this, "天设置为" + s, Toast.LENGTH_SHORT).show();
                                    inputDialog.dismiss();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "请输入数据!", Toast.LENGTH_SHORT).show();
                            }
                            day.setValue(Integer.parseInt(mTvDay.getText().toString()));
                        }
                    });
                    inputDialog.show();
                    break;
                case R.id.clock_tv_hour:
                    final InputDialog inputDialog2 = new InputDialog(MainActivity.this);
                    inputDialog2.setClick(new InputDialog.IOnClickLitener() {
                        @Override
                        public void onClick(InputDialog inputDialog) {
                            String s = inputDialog.getString();
                            if (!s.equals("")) {
                                if (Integer.parseInt(s) >= 24 && direction) {
                                    Toast.makeText(MainActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                                } else {
                                    mTvHour.setText(s);
                                    Toast.makeText(MainActivity.this, "小时设置为" + s, Toast.LENGTH_SHORT).show();
                                    inputDialog.dismiss();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "请输入数据!", Toast.LENGTH_SHORT).show();
                            }

                            hour.setValue(Integer.parseInt(mTvHour.getText().toString()));
                        }
                    });
                    inputDialog2.show();
                    break;
                case R.id.clock_tv_minute:
                    final InputDialog inputDialog3 = new InputDialog(MainActivity.this);
                    inputDialog3.setClick(new InputDialog.IOnClickLitener() {
                        @Override
                        public void onClick(InputDialog inputDialog) {
                            String s = inputDialog.getString();
                            if (!s.equals("")) {
                                if (Integer.parseInt(s) >= 60 && direction) {
                                    Toast.makeText(MainActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                                } else {
                                    mTvMinute.setText(s);
                                    Toast.makeText(MainActivity.this, "分钟设置为" + s, Toast.LENGTH_SHORT).show();
                                    inputDialog.dismiss();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "请输入数据!", Toast.LENGTH_SHORT).show();
                            }

                            minute.setValue(Integer.parseInt(mTvMinute.getText().toString()));
                        }
                    });
                    inputDialog3.show();
                    break;
                case R.id.clock_tv_second:
                    final InputDialog inputDialog4 = new InputDialog(MainActivity.this);
                    inputDialog4.setClick(new InputDialog.IOnClickLitener() {
                        @Override
                        public void onClick(InputDialog inputDialog) {
                            String s = inputDialog.getString();
                            if (!s.equals("")) {
                                if (Integer.parseInt(s) >= 60) {
                                    Toast.makeText(MainActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                                } else {
                                    mTvSecond.setText(s);
                                    Toast.makeText(MainActivity.this, "秒设置为" + s, Toast.LENGTH_SHORT).show();
                                    inputDialog.dismiss();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "请输入数据!", Toast.LENGTH_SHORT).show();
                            }

                            second.setValue(Integer.parseInt(mTvSecond.getText().toString()));
                        }
                    });
                    inputDialog4.show();
                    break;
            }
        }

    }

    void setListeners() {
        onClick onClick = new onClick();
        mTvDay.setOnClickListener(onClick);
        mTvHour.setOnClickListener(onClick);
        mTvMinute.setOnClickListener(onClick);
        mTvSecond.setOnClickListener(onClick);
        mBtnStart.setOnClickListener(onClick);
        mBtnReset.setOnClickListener(onClick);
        mBtnReset.setOnClickListener(onClick);
        mBtnGaoji.setOnClickListener(onClick);
        mBtnQueding.setOnClickListener(onClick);
        mBtnSwitch.setOnClickListener(onClick);
    }
}
