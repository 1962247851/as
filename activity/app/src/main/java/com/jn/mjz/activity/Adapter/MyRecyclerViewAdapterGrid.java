package com.jn.mjz.activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class MyRecyclerViewAdapterGrid extends RecyclerView.Adapter<MyRecyclerViewAdapterGrid.ViewHolder> {
    private Context mContext;
    private MyOnItemClickListener myOnItemClickListener;

    public MyRecyclerViewAdapterGrid(Context context, MyOnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.myOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapterGrid.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapterGrid.ViewHolder viewHolder, final int i) {
        //TO DO...
        viewHolder.mTv.setText("" + i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.onClick(i);
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

    @Override
    public int getItemCount() {
        return 20;
    }
}
