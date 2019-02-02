package com.math.mjz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class CalcluteActivity extends AppCompatActivity {
    private TextView mTextViewNuma;
    private TextView mTextViewNumb;
    private TextView mTextViewFuhao;
    private TextView mTextViewAnswer;
    private TextView mTextViewTips;
    private TextView mTextViewLevel;
    private TextView mTextViewSymbol;
    private TextView mTextViewAnswerN;
    private LinearLayout mLinearLayoutSelect;
    private LinearLayout mLinearLayoutTv;
    private LinearLayout mLinearLayoutBtn;
    private LinearLayout mLinearLayoutTips;
    private LinearLayout mLinearLayoutStart;
    private CheckBox mCheckBoxPuls;
    private CheckBox mCheckBoxSubtract;
    private CheckBox mCheckBoxMultiply;
    private CheckBox mCheckBoxDivide;
    private RadioButton mCheckBoxGettingStarted;
    private RadioButton mCheckBoxGeneral;
    private RadioButton mCheckBoxAdvanced;
    private RadioButton mCheckboxDifficult;
    private Button mButtonNum0;
    private Button mButtonNum1;
    private Button mButtonNum2;
    private Button mButtonNum3;
    private Button mButtonNum4;
    private Button mButtonNum5;
    private Button mButtonNum6;
    private Button mButtonNum7;
    private Button mButtonNum8;
    private Button mButtonNum9;
    private Button mButtonQueDing;
    private Button mButtonStart;
    private Button mButtonReset;
    private Button mButtonSubmit;
    private Button mButtonBack;
    private Button mButtonNegative;
    private Button mButtonAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calclute);
        mTextViewNuma = findViewById(R.id.textViewNumA);
        mTextViewNumb = findViewById(R.id.textViewNumB);
        mTextViewFuhao = findViewById(R.id.textViewFuHao);
        mTextViewTips = findViewById(R.id.textViewTips);
        mTextViewAnswer = findViewById(R.id.textViewAnswer);
        mTextViewLevel = findViewById(R.id.tv_level);
        mTextViewSymbol = findViewById(R.id.textViewFuHao);
        mTextViewAnswerN = findViewById(R.id.tv_answer);
        mLinearLayoutTips = findViewById(R.id.llt_tips);
        mLinearLayoutSelect = findViewById(R.id.llt_select);
        mLinearLayoutTv = findViewById(R.id.llt_tv);
        mLinearLayoutBtn = findViewById(R.id.llt_btn);
        mLinearLayoutStart = findViewById(R.id.llt_btnStart);
        mCheckBoxPuls = findViewById(R.id.checkBox1);
        mCheckBoxSubtract = findViewById(R.id.checkBox2);
        mCheckBoxMultiply = findViewById(R.id.checkBox3);
        mCheckBoxDivide = findViewById(R.id.checkBox4);
        mCheckBoxGettingStarted = findViewById(R.id.checkBox5);
        mCheckBoxGeneral = findViewById(R.id.checkBox6);
        mCheckBoxAdvanced = findViewById(R.id.checkBox7);
        mCheckboxDifficult = findViewById(R.id.checkBox8);

        mButtonAuthor=findViewById(R.id.btn_author);
        mButtonAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalcluteActivity.this,"MJZ",Toast.LENGTH_LONG).show();
            }
        });

        {
            mButtonNum0 = findViewById(R.id.btn_n0);
            mButtonNum0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '0');
                }
            });
            mButtonNum1 = findViewById(R.id.btn_n1);
            mButtonNum1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '1');
                }
            });
            mButtonNum2 = findViewById(R.id.btn_n2);
            mButtonNum2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '2');
                }
            });
            mButtonNum3 = findViewById(R.id.btn_n3);
            mButtonNum3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '3');
                }
            });
            mButtonNum4 = findViewById(R.id.btn_n4);
            mButtonNum4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '4');
                }
            });
            mButtonNum5 = findViewById(R.id.btn_n5);
            mButtonNum5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '5');
                }
            });
            mButtonNum6 = findViewById(R.id.btn_n6);
            mButtonNum6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '6');
                }
            });
            mButtonNum7 = findViewById(R.id.btn_n7);
            mButtonNum7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '7');
                }
            });
            mButtonNum8 = findViewById(R.id.btn_n8);
            mButtonNum8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '8');
                }
            });
            mButtonNum9 = findViewById(R.id.btn_n9);
            mButtonNum9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = mTextViewAnswer.getText().toString();
                    mTextViewAnswer.setText(a + '9');
                }
            });
        }

        //难度选择完成后点击确定按钮
        {
            mButtonQueDing = findViewById(R.id.btn_queDing);
            mLinearLayoutStart.setVisibility(View.VISIBLE);
            mButtonQueDing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //判断是否选择了运算类型
                    Boolean isCheckedSymbol = false;
                    if (mCheckBoxPuls.isChecked() || mCheckBoxSubtract.isChecked() || mCheckBoxMultiply.isChecked() || mCheckBoxDivide.isChecked()) {
                        isCheckedSymbol = true;
                    }
                    Boolean isCheckedLevel = false;
                    if (mCheckBoxGettingStarted.isChecked() || mCheckBoxAdvanced.isChecked() || mCheckBoxGeneral.isChecked() || mCheckboxDifficult.isChecked()) {
                        isCheckedLevel = true;
                    }
                    //判断是否选择了运算类型和难度
                    int levelNuma = 0,levelNumb = 0;
                    String symbol = "";
                    String level = "";
                    if (isCheckedSymbol && isCheckedLevel) {
                        //难度
                        if (mCheckBoxGettingStarted.isChecked()) {
                            level += "入门";
                            levelNuma = 1;
                            levelNumb = 10;
                        }
                        else if (mCheckBoxGeneral.isChecked()) {
                            level += "普通";
                            levelNuma = 1;
                            levelNumb = 100;
                        }
                        else if (mCheckBoxAdvanced.isChecked()) {
                            level += "进阶";
                            levelNuma = 1;
                            levelNumb = 500;
                        }
                        else if (mCheckboxDifficult.isChecked()) {
                            level += "困难";
                            levelNuma = 1;
                            levelNumb = 1000;
                        }
                        //运算类型
                        if(mCheckBoxPuls.isChecked()){
                            symbol += "加法";
                        }
                        if(mCheckBoxSubtract.isChecked()){
                            symbol += "减法";
                        }
                        if(mCheckBoxMultiply.isChecked()){
                            symbol += "乘法";
                        }
                        if(mCheckBoxDivide.isChecked()){
                            symbol += "取商";
                        }
                        mTextViewLevel.setText(level);
                        mLinearLayoutBtn.setVisibility(View.GONE);
                        mLinearLayoutTips.setVisibility(View.VISIBLE);
                        mLinearLayoutTv.setVisibility(View.GONE);
                        mLinearLayoutBtn.setVisibility(View.GONE);
                        mButtonStart.setVisibility(View.VISIBLE);
                        mTextViewTips.setText("\n难度:" + level+"\n\n"+"运算类型:" + symbol+"\n\n"+"你将遇到区间["+levelNuma+","+levelNumb+"]内的数字\n");
                        mTextViewLevel.setText(level);
                        level = "";
                        symbol = "";
                    } else {
                        if (!isCheckedLevel && !isCheckedSymbol) {
                            Toast.makeText(CalcluteActivity.this, "请至少选择一个运算类型和难度", Toast.LENGTH_SHORT).show();
                        } else if (!isCheckedSymbol) {
                            Toast.makeText(CalcluteActivity.this, "请选择运算类型", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CalcluteActivity.this, "请选择难度", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            });
        }

        //开始计算按钮
        {
            mButtonStart = findViewById(R.id.btn_start);
            mButtonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewAnswer.setText("");
                    mLinearLayoutTv.setVisibility(View.VISIBLE);
                    mLinearLayoutBtn.setVisibility(View.VISIBLE);
                    int levelMax = 10;
                    int a = 0 ,b = 0;
                    String level = mTextViewLevel.getText().toString();
                    if (level.equals("普通")) {
                        levelMax = 100;
                    } else if (level.equals("进阶")) {
                        levelMax = 500;
                    } else if (level.equals("困难")) {
                        levelMax = 1000;
                    }
                    a = 1 + (int) (Math.random() * levelMax);
                    b = 1 + (int) (Math.random() * levelMax);
                    String strA = String.valueOf(a);
                    String strB = String.valueOf(b);
                    mTextViewNuma.setText(strA);
                    mTextViewNumb.setText(strB);
                    mTextViewTips.setText("");
                    mLinearLayoutStart.setVisibility(View.GONE);
                    //符号随机选择
                    int symbolNum = 0;
                    while(true){
                        symbolNum = 3 + (int) (Math.random()*10);
                        if(symbolNum == 3 || symbolNum == 4){
                            if(mCheckBoxPuls.isChecked()){
                                break;
                            }
                        }else if(symbolNum == 5 || symbolNum == 6){
                            if(mCheckBoxSubtract.isChecked()){
                                break;
                            }
                        }else if(symbolNum == 7 || symbolNum == 8){
                            if(mCheckBoxMultiply.isChecked()){
                                break;
                            }
                        }else if(symbolNum == 9 || symbolNum == 10){
                            if(mCheckBoxDivide.isChecked()){
                                break;
                            }
                        }
                    }
                    String answer = "";
                    String symbolStr = "";
                    switch(symbolNum){
                        case 3:
                        case 4: answer += String.valueOf(Integer.parseInt(strA)+Integer.parseInt(strB));symbolStr += "+";break;
                        case 5:
                        case 6: answer += String.valueOf(Integer.parseInt(strA)-Integer.parseInt(strB));symbolStr += "-";break;
                        case 7:
                        case 8:answer += String.valueOf(Integer.parseInt(strA)*Integer.parseInt(strB));symbolStr += "*";break;
                        default:answer += String.valueOf(Integer.parseInt(strA)/Integer.parseInt(strB));symbolStr += "/";;
                    }
                    mTextViewAnswerN.setText(answer);
                    mTextViewFuhao.setText(symbolStr);
                }
            });
        }

        //返回重新选择难度按钮
        mButtonBack = findViewById(R.id.btn_back);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayoutSelect.setVisibility(View.VISIBLE);
                mLinearLayoutStart.setVisibility(View.VISIBLE);
                mLinearLayoutBtn.setVisibility(View.GONE);
                mLinearLayoutTv.setVisibility(View.GONE);
                mTextViewAnswer.setText("");
                mTextViewTips.setText("请选择!");
                mButtonStart.setVisibility(View.GONE);
            }
        });

        mButtonReset = findViewById(R.id.btn_reset);
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewAnswer.setText("");
                mTextViewTips.setText("");
            }
        });

        //变成负数
        mButtonNegative=findViewById(R.id.btn_negative);
        mButtonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = mTextViewAnswer.getText().toString();
                if(userAnswer.equals("")){
                    Toast.makeText(CalcluteActivity.this,"请输入数字",Toast.LENGTH_SHORT).show();
                }else{
                    long userAnswerLongNum = - Integer.parseInt(userAnswer);
                    if (userAnswerLongNum > 2147483647){
                        Toast.makeText(CalcluteActivity.this,"输入的数字太大了",Toast.LENGTH_SHORT).show();
                        mTextViewAnswer.setText("");
                    }
                    else {
                        int userAnswerNum = Integer.parseInt(userAnswer);
                        userAnswerNum = - userAnswerNum;
                        if(userAnswerNum > 0){
                            Toast.makeText(CalcluteActivity.this,"负负得正哦",Toast.LENGTH_SHORT).show();
                        }
                        mTextViewAnswer.setText(Integer.toString(userAnswerNum));
                    }
                }
            }
        });


        //点击提交按钮
        mButtonSubmit = findViewById(R.id.btn_submit);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = (String) mTextViewNuma.getText();
                String strB = mTextViewNumb.getText().toString();
                //答案正误判断
                String userAnswer = mTextViewAnswer.getText().toString();
                String symbolStr = mTextViewSymbol.getText().toString();
                if(userAnswer.equals("")){
                    Toast.makeText(CalcluteActivity.this,"请输入答案后再提交!",Toast.LENGTH_SHORT).show();
                }else {
                    String answer = mTextViewAnswerN.getText().toString();
                    if (answer.equals(userAnswer)) {
                        Toast.makeText(CalcluteActivity.this, "恭喜你,答对了!", Toast.LENGTH_SHORT).show();
                        mTextViewTips.setText("干得漂亮!");
                    } else {
                        Toast.makeText(CalcluteActivity.this, "很抱歉,答错了!", Toast.LENGTH_SHORT).show();
                        mTextViewTips.setText("\n\n正确答案"+strA + symbolStr + strB + "=" + answer + "\n\n你的答案为" + userAnswer);
                    }

                    int levelMax = 10;
                    int a = 0 ,b = 0;
                    String level = mTextViewLevel.getText().toString();
                    if (level.equals("普通")) {
                        levelMax = 100;
                    } else if (level.equals("进阶")) {
                        levelMax = 500;
                    } else if (level.equals("困难")) {
                        levelMax = 1000;
                    }
                    a = 1 + (int) (Math.random() * levelMax);
                    b = 1 + (int) (Math.random() * levelMax);
                    String strAa = String.valueOf(a);
                    String strBb = String.valueOf(b);
                    mTextViewNuma.setText(strAa);
                    mTextViewNumb.setText(strBb);

                    //符号随机选择
                    int symbolNum;
                    while(true){
                        symbolNum = 3 + (int) (Math.random() * 10);
                        if(symbolNum == 3 || symbolNum == 4){
                            if(mCheckBoxPuls.isChecked()){
                                break;
                            }
                        }else if(symbolNum == 5 || symbolNum == 6){
                            if(mCheckBoxSubtract.isChecked()){
                                break;
                            }
                        }else if(symbolNum == 7 || symbolNum == 8){
                            if(mCheckBoxMultiply.isChecked()){
                                break;
                            }
                        }else if(symbolNum == 9 || symbolNum == 10){
                            if(mCheckBoxDivide.isChecked()){
                                break;
                            }
                        }
                    }
                    answer = "";
                    symbolStr = "";
                    strA = (String) mTextViewNuma.getText();
                    strB = mTextViewNumb.getText().toString();
                    switch(symbolNum){
                        case 3:
                        case 4: answer += String.valueOf(Integer.parseInt(strA)+Integer.parseInt(strB));symbolStr += "+";break;
                        case 5:
                        case 6: answer += String.valueOf(Integer.parseInt(strA)-Integer.parseInt(strB));symbolStr += "-";break;
                        case 7:
                        case 8:answer += String.valueOf(Integer.parseInt(strA)*Integer.parseInt(strB));symbolStr += "*";break;
                        default:answer += String.valueOf(Integer.parseInt(strA)/Integer.parseInt(strB));symbolStr += "/";;
                    }
                    mTextViewFuhao.setText(symbolStr);
                    mTextViewAnswer.setText("");
                    mTextViewAnswerN.setText(answer);
                }
            }
        });
    }
}
