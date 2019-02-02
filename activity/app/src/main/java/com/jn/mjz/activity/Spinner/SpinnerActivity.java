package com.jn.mjz.activity.Spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner mSpr, mSprDialog,mSpnStars;
    private String[] starArray = {"水星","金星","地球","火星","木星","土星"};
    private Integer[] iconArray = {R.drawable.bg_btn1,R.drawable.bg_btn1,R.drawable.bg_btn1,R.drawable.bg_btn1,R.drawable.bg_btn1,R.drawable.bg_btn1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        mSprDialog = findViewById(R.id.sp_spinnerDialog);
        mSpr = findViewById(R.id.sp_spinner);
        mSpnStars = findViewById(R.id.sp_spinnerDialogStars);
        initSpinner();
        initSpinnerStars();
        initSpinnerDialog();
    }

    private void initSpinnerStars() {
        //声明一个映射对象的队列,用于保存行星的图标与名称配对信息
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        //iconArray是行星的图标数组,starArray是行星的名称数组
        for(int i = 0;i<iconArray.length;i++){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("icon",iconArray[i]);
            item.put("name",starArray[i]);
            list.add(item);
        }
        SimpleAdapter starAdapter = new SimpleAdapter(this,list,R.layout.layout_simple_spinner_item_select,new String[]{"icon","name"},new int[]{R.id.iv_spinner_icon,R.id.tv_spinner_name});
        starAdapter.setDropDownViewResource(R.layout.layout_simple_spinner_item_select);

        mSpnStars.setPrompt("请选择行星");
        mSpnStars.setAdapter(starAdapter);
        mSpnStars.setSelection(0);
    }

    private void initSpinner() {
        final String[] item = {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.layout_spinner_item_select, item);
        arrayAdapter.setDropDownViewResource(R.layout.layout_spinner_item_select);
        mSpr.setAdapter(arrayAdapter);
        mSpr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ToastUtil.showMsg(getApplicationContext(), "只有1个？");
                        break;
                    case 1:
                        ToastUtil.showMsg(getApplicationContext(), "2个？");
                        break;
                    case 2:
                        ToastUtil.showMsg(getApplicationContext(), "3.。。3个？");
                        break;
                    case 3:
                        ToastUtil.showMsg(getApplicationContext(), "4个？？");
                        break;
                    case 4:
                        ToastUtil.showMsg(getApplicationContext(), "居然有5个！");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initSpinnerDialog() {
        String[] item = {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.layout_spinner_item_select, item);
        arrayAdapter.setDropDownViewResource(R.layout.layout_spinner_item_select);
        mSprDialog.setPrompt("请选择老婆数量");
        mSprDialog.setAdapter(arrayAdapter);
        mSprDialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ToastUtil.showMsg(getApplicationContext(), "只有1个？");
                        break;
                    case 1:
                        ToastUtil.showMsg(getApplicationContext(), "2个？");
                        break;
                    case 2:
                        ToastUtil.showMsg(getApplicationContext(), "3.。。3个？");
                        break;
                    case 3:
                        ToastUtil.showMsg(getApplicationContext(), "4个？？");
                        break;
                    case 4:
                        ToastUtil.showMsg(getApplicationContext(), "居然有5个！");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
