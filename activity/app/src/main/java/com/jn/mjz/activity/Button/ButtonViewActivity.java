package com.jn.mjz.activity.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jn.mjz.activity.R;

public class ButtonViewActivity extends AppCompatActivity {

    private Button mbtn1;
    private Button mbtn2;
    private Button mbtn3;
    private Button mbtn4;
    private Button mbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_view);
        mbtn1 = findViewById(R.id.btn_1);
        mbtn2 = findViewById(R.id.btn_2);
        mbtn3 = findViewById(R.id.btn_3);
        mbtn4 = findViewById(R.id.btn_4);
        mbtn5 = findViewById(R.id.btn_5);
        setOnclickListeners();
        setOnLongClickListeners();
    }

    private void setOnclickListeners(){
        Onclick onclick = new Onclick();
        mbtn1.setOnClickListener(onclick);
        mbtn2.setOnClickListener(onclick);
        mbtn3.setOnClickListener(onclick);
        mbtn4.setOnClickListener(onclick);
        mbtn5.setOnClickListener(onclick);
    }
    
    private void setOnLongClickListeners(){
        OnLongClick onLongClick = new OnLongClick();
        mbtn1.setOnLongClickListener(onLongClick);
        mbtn2.setOnLongClickListener(onLongClick);
        mbtn3.setOnLongClickListener(onLongClick);
        mbtn4.setOnLongClickListener(onLongClick);
        mbtn5.setOnLongClickListener(onLongClick);
    }

    public class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_1:
                    Toast.makeText(ButtonViewActivity.this,"按钮1被点击了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_2:
                    Toast.makeText(ButtonViewActivity.this,"按钮2被点击了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_3:
                    Toast.makeText(ButtonViewActivity.this,"按钮3被点击了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_4:
                    Toast.makeText(ButtonViewActivity.this,"按钮4被点击了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_5:
                    Toast.makeText(ButtonViewActivity.this,"按钮5被点击了",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public class OnLongClick implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View v) {
            switch (v.getId()){
                case R.id.btn_1:
                    Toast.makeText(ButtonViewActivity.this,"按钮1被长按了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_2:
                    Toast.makeText(ButtonViewActivity.this,"按钮2被长按了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_3:
                    Toast.makeText(ButtonViewActivity.this,"按钮3被长按了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_4:
                    Toast.makeText(ButtonViewActivity.this,"按钮4被长按了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_5:
                    Toast.makeText(ButtonViewActivity.this,"按钮5被长按了",Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    }
}