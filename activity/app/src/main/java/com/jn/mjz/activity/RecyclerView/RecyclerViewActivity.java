package com.jn.mjz.activity.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jn.mjz.activity.R;
import com.jn.mjz.activity.Util.ToastUtil;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button mBtnLinear, mBtnGrid, mBtnStagger, mBtnLinearr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear = findViewById(R.id.rv_btn_linear);
        mBtnGrid = findViewById(R.id.rv_btnGrid);
        mBtnStagger = findViewById(R.id.rv_btnStagger);
        mBtnLinearr = findViewById(R.id.rv_btn_linearr);
        setClickListeners();

    }

    protected class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.rv_btn_linear:
                    intent = new Intent(RecyclerViewActivity.this, LinearRecyclerView.class);
                    break;
                case R.id.rv_btn_linearr:
                    intent = new Intent(RecyclerViewActivity.this, LinearRecyclerVieww.class);
                    break;
                case R.id.rv_btnGrid:
                    intent = new Intent(RecyclerViewActivity.this, GridRecyclerView.class);
                    break;
                case R.id.rv_btnStagger:
                    intent = new Intent(RecyclerViewActivity.this, StaggerRecyclerView.class);
                    break;
                default:
                    ToastUtil.showMsg(RecyclerViewActivity.this, "学习中。。。");
            }
            if (!(intent == null)) {
                startActivity(intent);
            }
        }
    }

    protected void setClickListeners() {
        OnClick onClick = new OnClick();
        mBtnLinear.setOnClickListener(onClick);
        mBtnGrid.setOnClickListener(onClick);
        mBtnStagger.setOnClickListener(onClick);
        mBtnLinearr.setOnClickListener(onClick);
    }
}
