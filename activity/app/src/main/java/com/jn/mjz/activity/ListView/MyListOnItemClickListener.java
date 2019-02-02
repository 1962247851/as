package com.jn.mjz.activity.ListView;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.jn.mjz.activity.Util.ToastUtil;

public class MyListOnItemClickListener implements AdapterView.OnItemClickListener {
    private Context mContext;

    public MyListOnItemClickListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.showMsg(mContext, "点击pos" + position+"\n自定义监听器继承自OnItemClickListener");
    }
}
