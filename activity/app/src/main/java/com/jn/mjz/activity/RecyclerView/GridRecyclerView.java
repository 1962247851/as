package com.jn.mjz.activity.RecyclerView;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jn.mjz.activity.Adapter.MyRecyclerViewAdapterGrid;
import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class GridRecyclerView extends AppCompatActivity {

    private RecyclerView mRvGrid;
    private Button mBtnIncreaseSpanCount, mBtnDecreaseSpanCount;
    private int spanCount = 1;
    private GridLayoutManager gridLayoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.id_recyclerViewGrid);
        mBtnIncreaseSpanCount = findViewById(R.id.btn_switch_spanCountIncrease);
        mBtnDecreaseSpanCount = findViewById(R.id.btn_switch_spanCountDecrease);
        mBtnIncreaseSpanCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutManager.setSpanCount(++spanCount);
            }
        });
        mBtnDecreaseSpanCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spanCount == 1) {
                    ToastUtil.showMsg(getApplicationContext(), "不能再减少了");
                } else {
                    gridLayoutManager.setSpanCount(--spanCount);
                }
            }
        });

        if (gridLayoutManager == null) {
            gridLayoutManager = new GridLayoutManager(getApplicationContext(), spanCount);
        }
        mRvGrid.setLayoutManager(gridLayoutManager);
        mRvGrid.setAdapter(new MyRecyclerViewAdapterGrid(getApplicationContext(), new MyRecyclerViewAdapterGrid.MyOnItemClickListener() {

            @Override
            public void onClick(int i) {
                ToastUtil.showMsg(GridRecyclerView.this, i + "（接口回调）");
            }
        }));
        mRvGrid.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(getResources().getDimensionPixelOffset(R.dimen.dividerHeight), getResources().getDimensionPixelOffset(R.dimen.dividerHeight), getResources().getDimensionPixelOffset(R.dimen.dividerHeight), getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
