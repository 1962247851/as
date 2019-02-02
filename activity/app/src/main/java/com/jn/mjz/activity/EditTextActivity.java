package com.jn.mjz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    private Button mButtonReset;
    private Button mButtonLogin;
    private Button mButtonBack;
    private EditText mEdit2;
    private EditText mEdit1;
    private TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mButtonReset = findViewById(R.id.btn_reset);
        mButtonBack = findViewById(R.id.back_login);
        mEdit1 = findViewById(R.id.ed_1);
        mEdit2 = findViewById(R.id.ed_2);
        mTextViewLogin = findViewById(R.id.tv_login);
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit2.setText("");
                mEdit1.setText("");
            }
        });
        mButtonLogin = findViewById(R.id.btn_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = mEdit1.getText().toString();
                String password = mEdit2.getText().toString();
                if (number.equals("") == false) {
                    if (password.equals("123456")) {
                        Toast.makeText(EditTextActivity.this, "欢迎" + number, Toast.LENGTH_LONG).show();
                        mEdit1.setVisibility(View.GONE);
                        mEdit2.setVisibility(View.GONE);
                        mButtonLogin.setVisibility(View.GONE);
                        mButtonReset.setVisibility(View.GONE);
                        mTextViewLogin.setVisibility(View.VISIBLE);
                        mButtonBack.setVisibility(View.VISIBLE);
                    } else if (password.equals("")) {
                        Toast.makeText(EditTextActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(EditTextActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                        mEdit2.setText("");
                    }
                } else {
                    Toast.makeText(EditTextActivity.this, "请输入电话", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditTextActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
