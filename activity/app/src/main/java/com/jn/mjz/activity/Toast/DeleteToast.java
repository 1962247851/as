package com.jn.mjz.activity.Toast;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.jn.mjz.activity.R;

public class DeleteToast extends Toast {
    private TextView mTvContent, mTvCancel;
    private View mView;
    private LayoutInflater mLayoutInflater;
    private DeleteToast mDeleteToast;
    private String mContent, mCancel;
    private IOnCancelClickListener mIOnCancelClickListener;

    public DeleteToast(Context context, IOnCancelClickListener iOnCancelClickListener, final int id) {
        super(context);
        this.mIOnCancelClickListener = iOnCancelClickListener;
        mLayoutInflater = LayoutInflater.from(context);
        mView = mLayoutInflater.inflate(R.layout.layout_delete_toast, null);
        mTvContent = mView.findViewById(R.id.tv_DeleteToastContent);
        mTvCancel = mView.findViewById(R.id.tv_DeleteToastCancel);
        this.setView(mView);



        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIOnCancelClickListener.onClick(id);
            }
        });
    }

    public DeleteToast setmContent(String mContent) {
        this.mContent = mContent;
        if (!TextUtils.isEmpty(mContent)) {
            mTvContent.setText(mContent);
        }
        return this;
    }

    public DeleteToast setmCancel(String mCancel) {
        this.mCancel = mCancel;
        if (!TextUtils.isEmpty(mCancel)) {
            mTvCancel.setText(mCancel);
        }
        return this;
    }

    @Override
    public void setView(View view) {
        super.setView(mView);
    }


    public interface IOnCancelClickListener {
        void onClick(int id);
    }

    public void showDeleteMsg(Context context, final int id, String content, String delete, IOnCancelClickListener iOnCancelClickListener) {
        if (mDeleteToast == null) {
            mDeleteToast = new DeleteToast(context, iOnCancelClickListener, id);
            mDeleteToast.setmContent(content).setmCancel(delete);
            mDeleteToast.setView(mView);
        }
        mDeleteToast.show();
    }
}
