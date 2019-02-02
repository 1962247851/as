package com.jn.mjz.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton mRadioButtonLevel1;
    private RadioButton mRadioButtonLevel2;
    private RadioButton mRadioButtonLevel3;
    private RadioButton mRadioButtonLevel4;
    private TextView mTextViewLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        mRadioButtonLevel1=findViewById(R.id.radioBtnLevel1);
        mRadioButtonLevel1.setOnClickListener(this);
        mRadioButtonLevel2=findViewById(R.id.radioBtnLevel2);
        mRadioButtonLevel2.setOnClickListener(this);
        mRadioButtonLevel3=findViewById(R.id.radioBtnLevel3);
        mRadioButtonLevel3.setOnClickListener(this);
        mRadioButtonLevel4=findViewById(R.id.radioBtnLevel4);
        mRadioButtonLevel4.setOnClickListener(this);
        mTextViewLevel=findViewById(R.id.tvLevel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioBtnLevel1:
                mTextViewLevel.setText("你选择的等级是level1");
                break;
            case R.id.radioBtnLevel2:
                mTextViewLevel.setText("你选择的等级是level2");
                break;
            case R.id.radioBtnLevel3:
                mTextViewLevel.setText("你选择的等级是level3");
                break;
            case R.id.radioBtnLevel4:
                mTextViewLevel.setText("你选择的等级是level4");
                break;
        }
    }
}
