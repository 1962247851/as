package com.jn.mjz.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jn.mjz.activity.Dialog.CustomDialog;
import com.jn.mjz.activity.Dialog.InputDialog;
import com.jn.mjz.activity.Util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private int choicedId = 0;

    private boolean[] itemsChecked = {false, false, false, false};
    private Button mButtonNormalDialog;
    private Button mButtonSingleDialog;
    private Button mButtonMultiDialog;
    private Button mButtonProgressDialog, mButtonCustomDialog, mBtnInputDialog;
    private InputDialog mInputDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        mButtonNormalDialog = findViewById(R.id.btnNormalDialog);
        mButtonSingleDialog = findViewById(R.id.btnSingleDialog);
        mButtonMultiDialog = findViewById(R.id.btnMultiDialog);
        mButtonProgressDialog = findViewById(R.id.btnProgressDialog);
        mButtonCustomDialog = findViewById(R.id.btnCustomDialog);
        mBtnInputDialog = findViewById(R.id.btnInputDialog);
        setClickListeners();
    }

    private void setClickListeners() {
        OnClick onClick = new OnClick();
        mButtonNormalDialog.setOnClickListener(onClick);
        mButtonSingleDialog.setOnClickListener(onClick);
        mButtonMultiDialog.setOnClickListener(onClick);
        mButtonProgressDialog.setOnClickListener(onClick);
        mButtonCustomDialog.setOnClickListener(onClick);
        mBtnInputDialog.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        ProgressDialog progressDialog = new ProgressDialog(DialogActivity.this);
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (progressDialog.getProgress() < 100) {
                    handler.postDelayed(runnable, 100);
                } else {
                    progressDialog.setProgress(0);
                    handler.removeMessages(0);
                    progressDialog.dismiss();
                    ToastUtil.showMsg(getApplicationContext(), "学习完成!");
                }
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressDialog.setProgress(progressDialog.getProgress() + 1);
                handler.sendEmptyMessage(0);
            }
        };

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnNormalDialog:
                    DialogInterface.OnClickListener listenerYes = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    };
                    DialogInterface.OnClickListener listenerNo = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    };
                    //声明对象
                    AlertDialog normalDialog;
                    //绑定当前界面窗口,设置标题
                    normalDialog = new AlertDialog.Builder(DialogActivity.this).setTitle("Dialog对话框!!!")
                            .setMessage("真的要退出吗?")//设置提示信息
                            .setCancelable(false)
                            .setIcon(R.drawable.ic_launcher_foreground)
                            .setPositiveButton("确定", listenerYes)
                            .setNegativeButton("取消", listenerNo)
                            .create();//创建对话框
                    normalDialog.show();//显示对话框
                    break;
                case R.id.btnSingleDialog:
                    final String[] sex = {"男", "女"};
                    //生成对话框
                    new AlertDialog.Builder(DialogActivity.this)
                            .setTitle("请选择性别")
                            .setSingleChoiceItems(sex, choicedId,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            choicedId = which;
                                            //      Toast.makeText(DialogActivity.this,"你选择的id是" + which,Toast.LENGTH_SHORT).show();
                                            Toast.makeText(DialogActivity.this, sex[choicedId], Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    }
                            )
                            .show();

                    break;

                case R.id.btnMultiDialog:
                    final String[] items = {"加法", "减法", "乘法", "取余"};

                    //生成对话框
                    final AlertDialog multiDialog = new AlertDialog.Builder(DialogActivity.this)
                            .setTitle("请选择运算类型!")
                            .setMultiChoiceItems(items
                                    , itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                            itemsChecked[which] = isChecked;
                                            // Toast.makeText(DialogActivity.this,"选择的id为"+which,Toast.LENGTH_SHORT).show();
                                        }
                                    })
                            .setCancelable(false)
                            .setPositiveButton("确定", null)
                            .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).create();
                    multiDialog.show();


                    multiDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String checkedItem = "";
                            int size = items.length;
                            for (int i = 0; i < size; i++) {
                                if (itemsChecked[i]) {
                                    switch (i) {
                                        case 0:
                                            checkedItem += "加法";
                                            break;
                                        case 1:
                                            checkedItem += "减法";
                                            break;
                                        case 2:
                                            checkedItem += "乘法";
                                            break;
                                        case 3:
                                            checkedItem += "取余";
                                            break;
                                    }
                                }
                            }
                            if (checkedItem.equals("")) {
                                Toast.makeText(DialogActivity.this, "请至少选择一项", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(DialogActivity.this, "你选择了:\n" + checkedItem, Toast.LENGTH_LONG).show();
                                multiDialog.cancel();
                            }
                        }
                    });
                    break;
                case R.id.btnProgressDialog:
                    progressDialog.setTitle("进度条对话框");
                    //设置水平进度条
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setMessage("正在学习中...\n进度:");
                    progressDialog.show();
                    handler.sendEmptyMessage(0);
                    break;
                case R.id.btnCustomDialog:
                    final CustomDialog customDialog = new CustomDialog(DialogActivity.this);
                    customDialog.setCancelable(false);
                    customDialog.setTitle("提示:").setMessage("确认退出?")
                            .setCancel("算了算了", new CustomDialog.IOnCancelListener() {
                                @Override
                                public void onCancel(CustomDialog dialog) {
                                    customDialog.cancel();
                                }
                            }).setConfirm("溜了溜了", new CustomDialog.IOnConfirmListener() {
                        @Override
                        public void onConfirm(CustomDialog dialog) {
                            finish();
                        }
                    }).show();
                    break;
                case R.id.btnInputDialog:
                    if (mInputDialog == null) {
                        mInputDialog = new InputDialog(DialogActivity.this, new InputDialog.IOnCancelClickListener() {
                            @Override
                            public void onCancelClick(String string) {
                                mInputDialog.dismiss();
                            }
                        }, new InputDialog.IOnConfirmClickListener() {
                            @Override
                            public void onConfirmClick(String string) {
                                ToastUtil.showMsg(DialogActivity.this, string);
                                mInputDialog.dismiss();
                            }
                        });
                    }
                    mInputDialog.setCancelable(false);
                    mInputDialog.setTitle("请输入你的姓名").setCancel("取消~").setConfirm("确定!").show();
                    break;
            }
        }


    }
}
