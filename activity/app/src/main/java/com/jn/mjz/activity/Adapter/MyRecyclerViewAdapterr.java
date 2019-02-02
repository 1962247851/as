package com.jn.mjz.activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class MyRecyclerViewAdapterr extends RecyclerView.Adapter<MyRecyclerViewAdapterr.ViewHolder> {
    private Context mContext;
    private MyOnItemClickListener myOnItemClickListener;
    private MyOnItemLongClickListener myOnItemLongClickListener;
    public MyRecyclerViewAdapterr(Context context,MyOnItemClickListener onItemClickListener,MyOnItemLongClickListener onItemLongClickListener) {
        this.mContext = context;
        this.myOnItemClickListener = onItemClickListener;
        this.myOnItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapterr.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapterr.ViewHolder viewHolder, final int i) {
        //TO DO...
        viewHolder.mTv.setText("" + i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.onClick(i);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myOnItemLongClickListener.onLongClick(i);
                return true;
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv_rv);
        }
    }

    public interface MyOnItemClickListener {
        void onClick(int i);
    }

    public interface MyOnItemLongClickListener{
        void onLongClick(int i);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
