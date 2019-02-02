package jn.mjz.web;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] stringName, stringUrl;
    private IOnItemClickListener mIOnItemClickListener;

    public ListViewAdapter(Context context, String[] stringsName, String[] stringsUrl, IOnItemClickListener iOnItemClickListener) {
        this.mContext = context;
        this.stringName = stringsName;
        this.stringUrl = stringsUrl;
        this.mIOnItemClickListener = iOnItemClickListener;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stringName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class MyViewHolder {
        private TextView mTv;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.layout_list_view_item, null);
            myViewHolder.mTv = convertView.findViewById(R.id.tv_layout_list_item);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        //
        myViewHolder.mTv.setText(stringName[position]);
        myViewHolder.mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIOnItemClickListener.onItemClick(position);
            }
        });
        return convertView;
    }

    public interface IOnItemClickListener {
        void onItemClick(int index);
    }
}
