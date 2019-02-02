package com.jn.mjz.activity.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class InputDialog extends Dialog {
    private EditText mEt;
    private TextView mTvTitle, mTvConfirm, mTvCancel;
    private IOnCancelClickListener mIOnCancelClickListener;
    private IOnConfirmClickListener mIOnConfirmClickListener;

    public InputDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public InputDialog setConfirm(String confirm) {
        this.confirm = confirm;
        return this;
    }

    public InputDialog setCancel(String cancel) {
        this.cancel = cancel;
        return this;
    }

    private String title, confirm, cancel;

    public InputDialog(Context context, IOnCancelClickListener iOnCancelClickListener, IOnConfirmClickListener iOnConfirmClickListener) {
        super(context);
        this.mIOnCancelClickListener = iOnCancelClickListener;
        this.mIOnConfirmClickListener = iOnConfirmClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_input_dialog);
        mEt = findViewById(R.id.dialog_edit_text);
        mTvTitle = findViewById(R.id.input_dialog_tv_title);
        mTvConfirm = findViewById(R.id.input_dialog_tv_confirm);
        mTvCancel = findViewById(R.id.input_dialog_tv_cancel);
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIOnCancelClickListener.onCancelClick(mEt.getText().toString());
            }
        });
        mTvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIOnConfirmClickListener.onConfirmClick(mEt.getText().toString());
            }
        });
    }

    public interface IOnConfirmClickListener {
        void onConfirmClick(String string);

    }

    public interface IOnCancelClickListener {
        void onCancelClick(String string);
    }
}
