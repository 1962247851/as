package com.jn.mjz.activity.ActionBar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Toast.DeleteToast;
import com.jn.mjz.activity.Util.ToastUtil;

public class ActionBarActivity extends AppCompatActivity {
    private Button mBtnAb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        mBtnAb = findViewById(R.id.btn_action_bar);
        setListeners();
    }

    void setListeners() {
        OnClick onClick = new OnClick();
        mBtnAb.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_action_bar:
                    ToastUtil.showMsg(ActionBarActivity.this, "努力学习中。。。");
                    break;
            }

        }
    }
}
