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

import com.jn.mjz.activity.Adapter.MyRecyclerViewAdapter;
import com.jn.mjz.activity.R;

public class LinearRecyclerView extends AppCompatActivity {
    private RecyclerView mRv;
    private LinearLayoutManager mLinearLayoutManager;
    private Button mBtnSwitchOrientation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        mRv = findViewById(R.id.id_recyclerView);
        if (mLinearLayoutManager == null) {
            mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        }
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(mLinearLayoutManager);
        mRv.setAdapter(new MyRecyclerViewAdapter(LinearRecyclerView.this));
        mRv.addItemDecoration(new MyDecoration());
        mBtnSwitchOrientation = findViewById(R.id.rv_btn_switch_direction);
        mBtnSwitchOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLinearLayoutManager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
                    mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                } else {
                    mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                }
            }
        });
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}