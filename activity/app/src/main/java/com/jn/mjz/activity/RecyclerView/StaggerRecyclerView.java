package com.jn.mjz.activity.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.jn.mjz.activity.Adapter.MyRecyclerViewAdapterStagger;
import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class StaggerRecyclerView extends AppCompatActivity {
    private RecyclerView mRvStagger;
    private int spanCount = 2, orientation = StaggeredGridLayoutManager.VERTICAL;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger_recycler_view);
        mRvStagger = findViewById(R.id.id_recyclerViewStagger);
        if (mLayoutManager == null) {
            mLayoutManager = new StaggeredGridLayoutManager(spanCount, orientation);
        }
        mRvStagger.setLayoutManager(mLayoutManager);
        mRvStagger.setAdapter(new MyRecyclerViewAdapterStagger(StaggerRecyclerView.this));
    }
}
