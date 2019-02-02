package com.jn.mjz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    private EditText mEditIntentBack;
    private Button mBtnIntentBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        mEditIntentBack = findViewById(R.id.ed_intentBack);
        mBtnIntentBack = findViewById(R.id.btn_intentBack);

        //Intent接收从Main传回的值
        Intent intent = getIntent();
        String text = intent.getStringExtra("EditTextText");
        if(!text.equals("")){
            Toast.makeText(IntentActivity.this,"传值成功",Toast.LENGTH_SHORT).show();
            mEditIntentBack.setText(text);
        }
        else{
            Toast.makeText(IntentActivity.this,"null",Toast.LENGTH_SHORT).show();
        }

        mBtnIntentBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //返回数据给IntentActivity,resultCode = 1,内容为EditTextBackText
                Intent intentBack = new Intent();
                String textBack = mEditIntentBack.getText().toString();
                if (!textBack.equals("")) {
                    Toast.makeText(IntentActivity.this, "回传成功", Toast.LENGTH_SHORT).show();
                    intentBack.putExtra("EditTextBackText",textBack);
                    setResult(1,intentBack);
                } else {
                    Toast.makeText(IntentActivity.this,"null",Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}
