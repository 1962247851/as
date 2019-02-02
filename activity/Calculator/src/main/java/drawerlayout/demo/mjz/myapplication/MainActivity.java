package drawerlayout.demo.mjz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtn0, mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtnPoint, mBtnIs, mBtnRoot, mBtnPlus, mBtnSubtract, mBtnMultipy, mBtnDivide, mBtnClear, mBtnClearEntry;
    private TextView mTv;
    private String operator = "", firstNum = "", nextNum = "", result = "", showText = "", number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setClickListeners();
    }

    private void setClickListeners() {
        OnClick onClick = new OnClick();
        mBtn0.setOnClickListener(onClick);
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
        mBtn4.setOnClickListener(onClick);
        mBtn5.setOnClickListener(onClick);
        mBtn6.setOnClickListener(onClick);
        mBtn7.setOnClickListener(onClick);
        mBtn8.setOnClickListener(onClick);
        mBtn9.setOnClickListener(onClick);
        mBtnPoint.setOnClickListener(onClick);
        mBtnPlus.setOnClickListener(onClick);
        mBtnSubtract.setOnClickListener(onClick);
        mBtnMultipy.setOnClickListener(onClick);
        mBtnDivide.setOnClickListener(onClick);
        mBtnRoot.setOnClickListener(onClick);
        mBtnIs.setOnClickListener(onClick);
        mBtnClear.setOnClickListener(onClick);
        mBtnClearEntry.setOnClickListener(onClick);
    }

    private void setViews() {
        mBtn0 = findViewById(R.id.btn0);
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn4 = findViewById(R.id.btn4);
        mBtn5 = findViewById(R.id.btn5);
        mBtn6 = findViewById(R.id.btn6);
        mBtn7 = findViewById(R.id.btn7);
        mBtn8 = findViewById(R.id.btn8);
        mBtn9 = findViewById(R.id.btn9);
        mBtnClear = findViewById(R.id.btnC);
        mBtnClearEntry = findViewById(R.id.btnCE);
        mBtnPlus = findViewById(R.id.btnPlus);
        mBtnSubtract = findViewById(R.id.btnSubtract);
        mBtnMultipy = findViewById(R.id.btnMultiply);
        mBtnDivide = findViewById(R.id.btnDivide);
        mBtnIs = findViewById(R.id.btnIs);
        mBtnPoint = findViewById(R.id.btnPoint);
        mBtnRoot = findViewById(R.id.btnRoot);
        mTv = findViewById(R.id.tv);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn0:
                    showText += "0";
                    number += "0";
                    break;
                case R.id.btn1:
                    showText += "1";
                    number += "1";
                    break;
                case R.id.btn2:
                    showText += "2";
                    number += "2";
                    break;
                case R.id.btn3:
                    showText += "3";
                    number += "3";
                    break;
                case R.id.btn4:
                    showText += "4";
                    number += "4";
                    break;
                case R.id.btn5:
                    showText += "5";
                    number += "5";
                    break;
                case R.id.btn6:
                    showText += "6";
                    number += "6";
                    break;
                case R.id.btn7:
                    showText += "7";
                    number += "7";
                    break;
                case R.id.btn8:
                    showText += "8";
                    number += "8";
                    break;
                case R.id.btn9:
                    showText += "9";
                    number += "9";
                    break;
                case R.id.btnPoint:
                    showText += ".";
                    number += ".";
                    break;
                case R.id.btnRoot:
                    operator = "√";
                    showText += operator;
                    break;
                case R.id.btnPlus:
                    operator = "+";
                    showText += operator;
                    firstNum = number;
                    number = "";
                    break;
                case R.id.btnSubtract:
                    operator = "-";
                    showText += operator;
                    firstNum = number;
                    number = "";
                    break;
                case R.id.btnMultiply:
                    operator = "×";
                    showText += operator;
                    nextNum = number;
                    number = "";
                    break;
                case R.id.btnDivide:
                    operator = "÷";
                    showText += operator;
                    nextNum = number;
                    number = "";
                    break;
                case R.id.btnIs:
                    nextNum = number;
                    number = "";
                    switch (operator) {
                        case "+":
                            result = String.valueOf((Integer.parseInt(firstNum) + Integer.parseInt(nextNum)));
                            break;
                        case "-":
                            result = String.valueOf((Integer.parseInt(firstNum) - Integer.parseInt(nextNum)));
                            break;
                        case "×":
                            result = String.valueOf((Integer.parseInt(firstNum) * Integer.parseInt(nextNum)));
                            break;
                        case "÷":
                            result = String.valueOf((Integer.parseInt(firstNum) / Integer.parseInt(nextNum)));
                            break;
                    }
                    Toast.makeText(MainActivity.this, "\nfirstNum:" + firstNum + "\noperator:" + operator + "\nnextNum:" + nextNum + "\nresult:" + result, Toast.LENGTH_SHORT).show();
                    firstNum = result;
                    operator = "=";
                    showText += (operator + result);
                    break;
                case R.id.btnC:
                    showText = "";
                    firstNum = "";
                    nextNum = "";
                    result = "";
                    number = "";
                    operator = "";
                    break;
            }
            mTv.setText(showText);
        }
    }
}
