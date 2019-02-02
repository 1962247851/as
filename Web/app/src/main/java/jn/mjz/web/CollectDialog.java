package jn.mjz.web;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CollectDialog extends Dialog {
    private EditText mEtName, mEtUrl;

    public String getStringName() {
        return mEtName.getText().toString();
    }

    public String getStringUrl() {
        return mEtUrl.getText().toString();
    }

    private String stringName, stringUrl;
    private IOnCancelClickListener mIOnCancelClickListener;
    private IOnConfirmClickListener mIOnConfirmClickListener;
    private Button mBtnCancel, mBtnConfirm;

    public CollectDialog(Context context, IOnCancelClickListener iOnCancelClickListener, IOnConfirmClickListener iOnConfirmClickListener) {
        super(context);
        this.mIOnCancelClickListener = iOnCancelClickListener;
        this.mIOnConfirmClickListener = iOnConfirmClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_collect);
        mBtnCancel = findViewById(R.id.btn_layout_cancel_collect_dialog);
        mBtnConfirm = findViewById(R.id.btn_layout_confirm_collect_dialog);
        mEtName = findViewById(R.id.et_layout_collect_name);
        mEtUrl = findViewById(R.id.et_layout_collect_url);
        if (!TextUtils.isEmpty(stringUrl)) {
            mEtUrl.setText(stringUrl);
        }
        if (!TextUtils.isEmpty(stringName)) {
            mEtName.setText(stringName);
        }
        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIOnConfirmClickListener != null) {
                    mIOnConfirmClickListener.onConfirmClick();
                }
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIOnCancelClickListener != null) {
                    mIOnCancelClickListener.onCancelClick();
                }
            }
        });
    }

    interface IOnCancelClickListener {
        void onCancelClick();
    }

    interface IOnConfirmClickListener {
        void onConfirmClick();
    }

    public CollectDialog setStringName(String stringName) {
        this.stringName = stringName;
        return this;
    }

    public CollectDialog setStringUrl(String stringUrl) {
        this.stringUrl = stringUrl;
        return this;
    }

}
