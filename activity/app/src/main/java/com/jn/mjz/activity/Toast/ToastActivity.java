package com.jn.mjz.activity.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1, mBtnToast2, mBtnToast3, mBtnToast4,mBtnDeleteToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_custom);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        mBtnDeleteToast = findViewById(R.id.btn_toast_delete);
        setOnclick();
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(), "默认Toast", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(ToastActivity.this, "Toast2", Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_custom:
                    //创建一个customToast
                    Toast customToast = new Toast(getApplicationContext());
                    //设定布局
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    //View绑定自定义布局里的元素
                    View view = inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView = view.findViewById(R.id.toast_img);
                    TextView textView = view.findViewById(R.id.toast_tv);
                    //给控件赋值
                    imageView.setImageResource(R.drawable.ic_launcher_foreground);
                    textView.setText("这是一个自定义的Toast\n什么时候能挤满整个横屏啊啊啊啊啊啊啊啊啊!");
                    //设置customToast的布局
                    customToast.setView(view);
                    //调用show方法
                    customToast.setGravity(Gravity.BOTTOM,0,0);
                    customToast.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(), "包装过的Toast");
                    break;
                case R.id.btn_toast_delete:
                    DeleteToast deleteToast = new DeleteToast(getApplicationContext(), new DeleteToast.IOnCancelClickListener() {
                        @Override
                        public void onClick(int id) {
                            mBtnDeleteToast.setText("已撤销删除id"+id);
                        }
                    },666);
                    deleteToast.setmContent("已删除"+666).setmCancel("撤销删除");
//                    try {
//                        Object mTN ;
//                        mTN = getField(deleteToast, "mTN");
//                        if (mTN != null) {
//                            Object mParams = getField(mTN, "mParams");
//                            if (mParams != null
//                                    && mParams instanceof WindowManager.LayoutParams) {
//                                WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
//                                //显示与隐藏动画
//                                //params.windowAnimations = R.style.ClickToast;
//                                //Toast可点击
//                                params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//
//                                //设置viewgroup宽高
////                                params.width = WindowManager.LayoutParams.MATCH_PARENT; //设置Toast宽度为屏幕宽度
////                                params.height = WindowManager.LayoutParams.WRAP_CONTENT; //设置高度
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    deleteToast.show();
                    break;
            }
        }
    }

    public void setOnclick() {
        OnClick onClick = new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
        mBtnDeleteToast.setOnClickListener(onClick);
    }
}
