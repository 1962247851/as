package com.jn.mjz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jn.mjz.activity.ActionBar.ActionBarActivity;
import com.jn.mjz.activity.Button.ButtonViewActivity;
import com.jn.mjz.activity.Clock.ClockViewActivity;
import com.jn.mjz.activity.Fragment.ContainerActivity;
import com.jn.mjz.activity.GridView.GridViewActivity;
import com.jn.mjz.activity.ListView.ListViewActivity;
import com.jn.mjz.activity.PopUp.PopUpWindowActivity;
import com.jn.mjz.activity.Progress.ProgressActivity;
import com.jn.mjz.activity.RecyclerView.RecyclerViewActivity;
import com.jn.mjz.activity.Spinner.SpinnerActivity;
import com.jn.mjz.activity.SwitchButton.SwitchButtonActivity;
import com.jn.mjz.activity.Toast.ToastActivity;

public class MainActivity extends AppCompatActivity {


    private Button mButtonTextView;
    private Button mButtonBtnView;
    private Button mButtonWstView;
    private Button mButtonEditView;
    private Button mButtonRadioButton;
    private Button mButtonImgView;
    private Button mButtonDialog;
    private Button mButtonIntent;
    private Button mButtonRecyclerView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnDrawerView;
    private Button mBtnSwipeRefreshView;
    private Button mBtnClock;
    private Button mBtnToast;
    private Button mBtnPop;
    private Button mBtnProgress;
    private Button mBtnFragment;
    private Button mBtnActionBar;
    private Button mBtnSwitch;
    private Button mBtnSpinner;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViews();
        setClickListeners();
    }

    private void setViews() {
        setContentView(R.layout.activity_main);
        mButtonTextView = findViewById(R.id.btn_textview);
        mButtonBtnView = findViewById(R.id.btn_btnview);
        mButtonWstView = findViewById(R.id.btn_wbsview);
        mButtonEditView = findViewById(R.id.btn_edittext);
        mButtonRadioButton = findViewById(R.id.btnRadio);
        mButtonImgView = findViewById(R.id.btnImage);
        mButtonDialog = findViewById(R.id.btnDialogs);
        mButtonIntent = findViewById(R.id.btnIntent);
        mButtonRecyclerView = findViewById(R.id.btnRecyclerView);
        mBtnListView = findViewById(R.id.btn_listView);
        mBtnGridView = findViewById(R.id.btn_gridView);
        mBtnDrawerView = findViewById(R.id.btn_drawerLayout);
        mBtnSwipeRefreshView = findViewById(R.id.btn_swipeRefreshLayout);
        mBtnClock = findViewById(R.id.btn_clock);
        mEditText = findViewById(R.id.ed_intent);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnProgress = findViewById(R.id.btn_progress);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnActionBar = findViewById(R.id.btn_actionBar);
        mBtnSwitch = findViewById(R.id.btn_switchButton);
        mBtnSpinner = findViewById(R.id.btn_spinner);
    }

    private void setClickListeners() {
        Onclick onclick = new Onclick();
        mButtonTextView.setOnClickListener(onclick);
        mButtonBtnView.setOnClickListener(onclick);
        mButtonWstView.setOnClickListener(onclick);
        mButtonEditView.setOnClickListener(onclick);
        mButtonRadioButton.setOnClickListener(onclick);
        mButtonImgView.setOnClickListener(onclick);
        mButtonDialog.setOnClickListener(onclick);
        mButtonIntent.setOnClickListener(onclick);
        mButtonRecyclerView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
        mBtnGridView.setOnClickListener(onclick);
        mBtnDrawerView.setOnClickListener(onclick);
        mBtnSwipeRefreshView.setOnClickListener(onclick);
        mBtnClock.setOnClickListener(onclick);
        mBtnToast.setOnClickListener(onclick);
        mBtnPop.setOnClickListener(onclick);
        mBtnProgress.setOnClickListener(onclick);
        mBtnFragment.setOnClickListener(onclick);
        mBtnActionBar.setOnClickListener(onclick);
        mBtnSwitch.setOnClickListener(onclick);
        mBtnSpinner.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = null;
            int intented = 0;
            switch (v.getId()) {
                case R.id.btn_textview:
                    //跳转到TextView演示界面
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_btnview:
                    //跳转到BtnView演示界面
                    intent = new Intent(MainActivity.this, ButtonViewActivity.class);
                    break;
                case R.id.btn_wbsview:
                    //跳转到WbsView演示界面
                    intent = new Intent(MainActivity.this, WebSiteActivity.class);
                    break;
                case R.id.btn_edittext:
                    //跳转到EditTextView演示界面
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btnRadio:
                    //跳转到RadioButtonView演示界面
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btnImage:
                    //跳转到ImageViewActivity演示界面
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btnDialogs:
                    //跳转到DialogsActivity演示界面
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.btnIntent:
                    //跳转到IntentActivity演示界面
                    intent = new Intent(MainActivity.this, IntentActivity.class);
                    //Intent传递editIntent的文字
                    intent.putExtra("EditTextText", mEditText.getText().toString());
                    intented = 1;
                    break;
                case R.id.btnRecyclerView:
                    //跳转到RecycleView演示界面
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_listView:
                    //跳转到ListView演示界面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridView:
                    //跳转到GridView演示界面
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_drawerLayout:
                    //跳转到DrawerView演示界面
                    intent = new Intent(MainActivity.this, DrawerViewActivity.class);
                    break;
                case R.id.btn_swipeRefreshLayout:
                    //跳转到SwipeRefreshLayout演示界面
                    intent = new Intent(MainActivity.this, SwipeRefreshLayoutActivity.class);
                    break;
                case R.id.btn_clock:
                    //跳转到Clock演示界面
                    intent = new Intent(MainActivity.this, ClockViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //跳转到Toast演示界面
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_pop:
                    //跳转到PopUpWindow演示界面
                    intent = new Intent(MainActivity.this, PopUpWindowActivity.class);
                    break;
                case R.id.btn_progress:
                    //跳转到Progress演示界面
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_fragment:
                    //跳转到Fragment演示界面
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_actionBar:
                    //跳转到ActionBar演示界面
                    intent = new Intent(MainActivity.this, ActionBarActivity.class);
                    break;
                case R.id.btn_switchButton:
                    //跳转到SwitchButton演示界面
                    intent = new Intent(MainActivity.this, SwitchButtonActivity.class);
                    break;
                case R.id.btn_spinner:
                    //跳转到Spinner演示界面
                    intent = new Intent(MainActivity.this, SpinnerActivity.class);
                    break;
            }
            if (intented == 0) {
                startActivity(intent);
            } else {
                startActivityForResult(intent, 1);
            }

        }
    }

    protected void onActivityResult(int requestsCode, int resultCode, Intent data) {
        super.onActivityResult(requestsCode, resultCode, data);
        if (requestsCode == 1) {
            if (resultCode == 1) {
                String string = data.getStringExtra("EditTextBackText");
                mEditText.setText(string);
            }
        }
    }
}
