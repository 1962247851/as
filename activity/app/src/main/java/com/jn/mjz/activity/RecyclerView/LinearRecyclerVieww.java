package com.jn.mjz.activity.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jn.mjz.activity.Adapter.MyRecyclerViewAdapterr;
import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class LinearRecyclerVieww extends AppCompatActivity {
    private RecyclerView mRv;
    private LinearLayoutManager mLinearLayoutManager;
    private Button mBtnSwitchOrientation;
private MyRecyclerViewAdapterr myRecyclerViewAdapterr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        mRv = findViewById(R.id.id_recyclerView);
        mBtnSwitchOrientation = findViewById(R.id.rv_btn_switch_direction);
        if (mLinearLayoutManager == null) {
            mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        }
        myRecyclerViewAdapterr = new MyRecyclerViewAdapterr(getApplicationContext(), new MyRecyclerViewAdapterr.MyOnItemClickListener() {
            @Override
            public void onClick(int i) {
                ToastUtil.showMsg(LinearRecyclerVieww.this, i + "（接口回调）");
            }
        }, new MyRecyclerViewAdapterr.MyOnItemLongClickListener() {
            @Override
            public void onLongClick(int i) {
                myRecyclerViewAdapterr.notifyItemMoved(i,i+3);
            }
        });
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(mLinearLayoutManager);
        mRv.setAdapter(myRecyclerViewAdapterr);
        mRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(getResources().getDimensionPixelOffset(R.dimen.dividerHeight), getResources().getDimensionPixelOffset(R.dimen.dividerHeight), getResources().getDimensionPixelOffset(R.dimen.dividerHeight),getResources().getDimensionPixelOffset(R.dimen.dividerHeight) );
            }
        });
        mRv.setPadding(10,10,10,10);
        mBtnSwitchOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLinearLayoutManager.getOrientation()==LinearLayoutManager.HORIZONTAL){
                    mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                }else{
                    mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                }
            }
        });
    }
}
