package com.jn.mjz.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class MyListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListViewAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        private ImageView mIv;
        private TextView mTvTitle, mTvTime, mTvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            viewHolder.mIv = convertView.findViewById(R.id.iv);
            viewHolder.mTvTitle = convertView.findViewById(R.id.tv_title);
            viewHolder.mTvTime = convertView.findViewById(R.id.tv_time);
            viewHolder.mTvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //赋值
        if (position % 2 == 0) {
            viewHolder.mTvTitle.setText("偶数");
        } else {
            viewHolder.mTvTitle.setText("奇数");
        }
        return convertView;
    }
}
