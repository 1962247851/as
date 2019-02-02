package com.jn.mjz.activity.SwitchButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class SwitchButtonActivity extends AppCompatActivity {

    private Switch mS;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);
        mS = findViewById(R.id.btn_switch_sb);
        mTv = findViewById(R.id.tv_switch_tv);
        mS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mS.isChecked()) {
                    mTv.setText("作弊模式已开启");

                } else {
                    mTv.setText("");
                }
            }
        });
    }
}
