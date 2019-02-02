package com.jn.mjz.activity.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jn.mjz.activity.R;

public class Fragment_a extends Fragment {
    private TextView mTvMessage;
    private Button mBtnChange, mBtnMessage, mBtnSwitch;
    private IOnMessageClick iOnMessageClick;
    private Fragment_b bFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvMessage = view.findViewById(R.id.fragment_a_tv);
        mBtnChange = view.findViewById(R.id.fragment_a_btn_change);
        mBtnMessage = view.findViewById(R.id.fragment_a_btn_message);
        mBtnSwitch = view.findViewById(R.id.fragment_a_btn_switch);
        mBtnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new Fragment_b();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fragment_fl, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_fl, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvMessage.setText("我是更换后的文字!");
            }
        });
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnMessageClick.onClick("通过回调接口实现Fragment与Activity间的信息交互");
                ContainerActivity containerActivity =  (ContainerActivity) getActivity();
                containerActivity.setData("在Activity内声明setData方法也可以,但不推荐");
            }
        });
    }

    public interface IOnMessageClick {
        void onClick(String string);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            iOnMessageClick = (IOnMessageClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity必须实现IOnMessageClick接口");
        }

    }
}