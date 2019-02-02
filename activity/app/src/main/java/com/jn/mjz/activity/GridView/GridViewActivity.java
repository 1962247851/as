package com.jn.mjz.activity.GridView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jn.mjz.activity.Adapter.MyGridViewAdapter;
import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class GridViewActivity extends AppCompatActivity {

    private GridView mGv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGv = findViewById(R.id.gv);
        mGv.setAdapter(new MyGridViewAdapter(GridViewActivity.this));
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position % 3 == 0) {
                    ToastUtil.showMsg(getApplicationContext(), "Hello");
                } else {
                    ToastUtil.showMsg(getApplicationContext(), String.valueOf(position));
                }
            }
        });
        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.showMsg(getApplicationContext(),"长按"+position);
                return true;
            }
        });
    }
}
