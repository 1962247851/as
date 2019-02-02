package com.jn.mjz.activity.PopUp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class PopUpWindowActivity extends AppCompatActivity {

    private Button mBtnPop, mBtnPop1;
    private TextView mTvMessage;
    private PopupWindow mPop, mPopNewMessage;
    private View view;
    private int messageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        setListeners();
    }

    protected void findViews() {
        setContentView(R.layout.activity_pop_up_window);
        mBtnPop = findViewById(R.id.pop_btn);
        mBtnPop1 = findViewById(R.id.pop_btn1);
        mTvMessage = findViewById(R.id.tv_message);
    }

    protected void setListeners() {
        onClickListener onClickListener = new onClickListener();
        onLongClickListener onLongClickListener = new onLongClickListener();
        mBtnPop1.setOnClickListener(onClickListener);
        mBtnPop1.setOnLongClickListener(onLongClickListener);
        mTvMessage.setOnClickListener(onClickListener);
        mBtnPop.setOnClickListener(onClickListener);
        mBtnPop.setOnLongClickListener(onLongClickListener);
    }

    class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            View view = getLayoutInflater().inflate(R.layout.layout_pop_up, null);
            TextView textView1 = view.findViewById(R.id.pop_tv1);
            TextView textView2 = view.findViewById(R.id.pop_tv2);
            TextView textView3 = view.findViewById(R.id.pop_tv3);
            TextView textView4 = view.findViewById(R.id.pop_tv4);
            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showMsg(getApplicationContext(), "TextView1");
                    mPop.dismiss();
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showMsg(getApplicationContext(), "TextView2");
                    mPop.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showMsg(getApplicationContext(), "TextView3");
                    mPop.dismiss();
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showMsg(getApplicationContext(), "TextView4");
                    mPop.dismiss();
                }
            });

            mPop = new PopupWindow(view, mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
            mPop.setContentView(view);
            mPop.setOutsideTouchable(true);
            mPop.setFocusable(true);
            switch (v.getId()) {
                case R.id.pop_btn:
                    mPop.showAsDropDown(mBtnPop);
                    break;
                case R.id.pop_btn1:
                    mPop.showAsDropDown(mBtnPop1);
                    break;
                case R.id.tv_message:
                    view = getLayoutInflater().inflate(R.layout.layout_pop_new_message, null);
                    TextView mTvNum = view.findViewById(R.id.tv_pop_new_message);
                    mPopNewMessage = new PopupWindow(view, getResources().getDimensionPixelOffset(R.dimen.PopUpWindowNewMessageWidth), getResources().getDimensionPixelOffset(R.dimen.PopUpWindowNewMessageHeight));
                    mPopNewMessage.setContentView(view);
                    String text = mTvMessage.getText().toString();
                    switch (text) {
                        case "+1":
                            if (messageNum + 1 == 99) {
                                mTvMessage.setText("-1");
                                ToastUtil.showMsg(PopUpWindowActivity.this, "不能再+1啦");
                            }
                            mTvNum.setText(++messageNum + "");
                            break;
                        case "-1":
                            if (messageNum - 1 == 1) {
                                mTvMessage.setText("+1");
                                ToastUtil.showMsg(PopUpWindowActivity.this, "不能再-1啦");
                            }
                            mTvNum.setText(--messageNum + "");
                            break;
                        default:
                            if (messageNum == 1) {
                                mTvMessage.setText("+1");
                            } else if (messageNum == 99) {
                                mTvMessage.setText("-1");
                            }

                    }
                    mPopNewMessage.showAsDropDown(mTvMessage, 25, -125, Gravity.RIGHT);


                    break;
            }
        }
    }

    class onLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {

            View view = getLayoutInflater().inflate(R.layout.layout_pop_up, null);
            TextView textView1 = view.findViewById(R.id.pop_tv1);
            TextView textView2 = view.findViewById(R.id.pop_tv2);
            TextView textView3 = view.findViewById(R.id.pop_tv3);
            TextView textView4 = view.findViewById(R.id.pop_tv4);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.pop_tv1:
                            ToastUtil.showMsg(getApplicationContext(), "TextView1");
                            mPop.dismiss();
                            break;
                        case R.id.pop_tv2:
                            ToastUtil.showMsg(getApplicationContext(), "TextView2");
                            mPop.dismiss();
                            break;
                        case R.id.pop_tv3:
                            ToastUtil.showMsg(getApplicationContext(), "TextView3");
                            mPop.dismiss();
                            break;
                        case R.id.pop_tv4:
                            ToastUtil.showMsg(getApplicationContext(), "TextView4");
                            mPop.dismiss();
                            break;
                    }
                }
            });
            mPop = new PopupWindow(view, mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
            mPop.setContentView(view);
            mPop.setOutsideTouchable(true);
            mPop.setFocusable(true);
            switch (v.getId()) {
                case R.id.pop_btn:
                    mPop.showAsDropDown(mBtnPop);
                    break;
                case R.id.pop_btn1:
                    mPop.showAsDropDown(mBtnPop1);
                    break;
            }
            return true;
        }
    }
}

