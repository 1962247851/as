package com.jn.mjz.activity.ListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jn.mjz.activity.Adapter.MyListViewAdapter;
import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class ListViewActivity extends AppCompatActivity {
    private ListView mLv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        MyListOnItemClickListener myListOnItemClickListener = new MyListOnItemClickListener(ListViewActivity.this);
        mLv = findViewById(R.id.lv_lv1);
        mLv.setAdapter(new MyListViewAdapter(getApplicationContext()));
        mLv.setOnItemClickListener(myListOnItemClickListener);
        mLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.showMsg(getApplicationContext(), "长按position" + position);
                return true;
            }
        });
    }
}
