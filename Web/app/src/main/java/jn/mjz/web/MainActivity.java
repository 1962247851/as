package jn.mjz.web;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private long exitTime = 0;
    private static UserDBHelper userDBHelper = null;
    private WebView mWv = null;
    private ProgressBar mPb = null;
    private String[] names = {"", "", "", ""}, urls = {"", "", "", ""};
    private final static String[][] bottoms = {{"爱折纸网", "https://www.aizhezhi.com/"}, {"折纸学院", "http://www.zhezhixueyuan.com/"}, {"手艺活网", "https://www.shouyihuo.com/"}, {"百度", "https://m.baidu.com"}};
    private String stringHome = "https://www.zhidiy.com/", stringUrl = "", stringEt = "", stringName = "";
    private EditText mEt = null;
    private TextView mTvMyCollections;
    private DrawerLayout mDl = null;
    private Button mBtnLeft = null, mBtnPop = null, mBtnCollect = null, mBtnClear = null, mBtnBottomOne = null, mBtnBottomTwo = null, mBtnBottomThree = null, mBtnBottomFour = null;
    private ListView mLv = null;
    private CollectDialog mCollectDialog = null;
    private PopupMenu mPm = null;
    private InputMethodManager mInputMethodManager = null;

    //保存功能
    private void shareWebCollect() {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, mCollectDialog.getStringName() + "\n" + mCollectDialog.getStringUrl());
        startActivity(Intent.createChooser(textIntent, "分享到"));

    }

    //分享网页
    private void shareWeb() {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, mWv.getTitle() + "\n" + mWv.getUrl());
        startActivity(Intent.createChooser(textIntent, mWv.getTitle()));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使通知栏透明化
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        //
        for (int i = 0; i < bottoms.length; i++) {
            names[i] = bottoms[i][0];
            urls[i] = bottoms[i][1];
        }
        initViews();
        initWebView();
        setListeners();
        mWv.loadUrl(stringHome);
    }

    //按钮点击事件
    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_main_open_left_view:
                    mDl.openDrawer(Gravity.LEFT);
                    break;
                case R.id.btn_main_collect:
                    initDialog();
                    break;
                case R.id.btn_layout_clear_edit_text:
                    mEt.setText("");
                    break;
                case R.id.btn_main_menu:
                    if (mPm == null) {
                        mPm = new PopupMenu(MainActivity.this, mBtnPop);
                        mPm.getMenuInflater().inflate(R.menu.menu_pop_menu, mPm.getMenu());
                        mPm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.item_menu_pop_up_refresh:
                                        mWv.reload();
                                        break;
                                    case R.id.item_menu_pop_up_forward:
                                        if (mWv.canGoForward()) {
                                            mWv.goForward();
                                        } else {
                                            Toast.makeText(MainActivity.this, "不能再前进啦", Toast.LENGTH_SHORT).show();
                                        }
                                        break;
                                    case R.id.item_menu_pop_up_back:
                                        if (mWv.canGoBack()) {
                                            mWv.goBack();
                                        } else {
                                            Toast.makeText(MainActivity.this, "不能再后退啦", Toast.LENGTH_SHORT).show();
                                        }
                                        break;
                                    case R.id.item_menu_pop_up_exit:
                                        finish();
                                        break;
                                    case R.id.item_menu_pop_up_home:
                                        mWv.loadUrl(stringHome);
                                        break;
                                    case R.id.item_menu_pop_up_share:
                                        shareWeb();
                                        break;
                                    case R.id.item_menu_pop_up_open_with_other:
                                        Uri uri = Uri.parse(mWv.getUrl());
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        startActivity(intent);
                                        break;
                                }
                                return true;
                            }
                        });
                        mPm.show();
                    } else {
                        mPm.show();
                    }
                    break;
                case R.id.tv_main_my_collections:
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("收藏功能说明：").setMessage("菜鸡开发者由于还没学会数据库，所以收藏功能暂时阉割。\nps:遇到bug请反馈").setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_main_bottom_1:
                    mWv.loadUrl(bottoms[0][1]);
                    break;
                case R.id.btn_main_bottom_2:
                    mWv.loadUrl(bottoms[1][1]);
                    break;
                case R.id.btn_main_bottom_3:
                    mWv.loadUrl(bottoms[2][1]);
                    break;
                case R.id.btn_main_bottom_4:
                    mWv.loadUrl(bottoms[3][1]);
                    break;
            }
        }
    }

    //文编编辑框监听事件
    class OnEditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEND
                    || actionId == EditorInfo.IME_ACTION_DONE
                    || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                //处理软键盘回车事件
                stringEt = mEt.getText().toString();
                if (!stringEt.equals("")) {
                    mWv.loadUrl("https://www.zhidiy.com/s-" + stringEt + ".html");
                    if (mPb.getProgress() < 100) {
                        mEt.setText("");
                        mEt.setHint("正在搜索“" + stringEt + "”请稍等...");
                    }
                    mEt.clearFocus();
                    hideAllInputMethod(MainActivity.this);
                } else {
                    Toast.makeText(MainActivity.this, "输入不能为空!", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        }
    }

    //返回键后退网页
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (!mDl.isDrawerOpen(Gravity.LEFT)) {
                    if (mWv.canGoBack()) {
                        mWv.goBack();
                    } else {
                        exit();
                    }
                } else {
                    mDl.closeDrawer(Gravity.LEFT);
                }
                break;
            default:
                Log.d("MainActivity", "onKeyDown: " + "keyCode" + keyCode + "\nevent" + event.toString());
        }
        return true;
    }

    //关闭软键盘
    public void hideAllInputMethod(Activity activity) {
        if (mInputMethodManager == null) {
            mInputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        if (mInputMethodManager.isActive()) {
            mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //设置监听事件
    private void setListeners() {
        OnClick onClick = new OnClick();
        OnEditorActionListener onEditorActionListener = new OnEditorActionListener();
        mBtnLeft.setOnClickListener(onClick);
        mBtnCollect.setOnClickListener(onClick);
        mBtnPop.setOnClickListener(onClick);
        mEt.setOnEditorActionListener(onEditorActionListener);
        mBtnClear.setOnClickListener(onClick);
        mBtnBottomOne.setOnClickListener(onClick);
        mBtnBottomTwo.setOnClickListener(onClick);
        mBtnBottomThree.setOnClickListener(onClick);
        mBtnBottomFour.setOnClickListener(onClick);
        mTvMyCollections.setOnClickListener(onClick);
    }

    //初始化WebView
    private void initWebView() {
        WebSettings webSettings = mWv.getSettings();
        //webSettings.setLoadWithOverviewMode(true);
        //webSettings.setUseWideViewPort(true);
        webSettings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webSettings.setLoadsImagesAutomatically(true);//自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置默认的文本编码
        webSettings.setJavaScriptEnabled(true);//支持js
        webSettings.setSupportZoom(true);//支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAppCacheEnabled(true);//支持缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWv.setWebViewClient(new MyWebViewClient());//不跳转到其他浏览器
        mWv.setWebChromeClient(new MyWebChromeClient());
    }

    class MyWebChromeClient extends WebChromeClient {
        //进度条
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100) {
                mPb.setProgress(0);
            } else {
                mPb.setProgress(newProgress);
            }
            if (newProgress > 80) {
                mEt.setHint("输入想要纸艺的内容");
            } else {
                mEt.setHint("网页加载中请稍等...");
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            stringName = title;
            if (mCollectDialog != null) {
                if (mCollectDialog.isShowing()) {
                    Toast.makeText(MainActivity.this, "成功获取网页标题：" + title, Toast.LENGTH_LONG).show();
                    mCollectDialog.cancel();
                    initDialog();
                }
            }
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
            b.setTitle("Alert");
            b.setMessage(message);
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.confirm();
                }
            });
            b.setCancelable(false);
            b.create().show();
            return true;
        }

        //设置响应js 的Confirm()函数
        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
            b.setTitle("Confirm");
            b.setMessage(message);
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.confirm();
                }
            });
            b.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.cancel();
                }
            });
            b.create().show();
            return true;
        }

        //设置响应js 的Prompt()函数
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
            final View v = View.inflate(MainActivity.this, R.layout.layout_dialog_collect, null);
            ((TextView) v.findViewById(R.id.tv_layout_prompt_title)).setText(message);
            ((EditText) v.findViewById(R.id.et_layout_prompt)).setText(defaultValue);
            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
            b.setTitle("Prompt");
            b.setView(v);
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String value = ((EditText) v.findViewById(R.id.et_layout_prompt)).getText().toString();
                    result.confirm(value);
                }
            });
            b.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.cancel();
                }
            });
            b.create().show();
            return true;
        }
    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            try {
                if (!url.startsWith("https://") || !url.startsWith("http://")) {
                    Intent intent = new Intent(Intent.ACTION_QUICK_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else {
                    mWv.loadUrl(url);
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
            //mWv.loadUrl(url);
            //return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(MainActivity.this, error.getDescription().toString() + "\nerrorCode:" + error.getErrorCode(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            stringUrl = url;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            stringName = view.getTitle();
        }
    }

    //初始化view
    private void initViews() {
        setContentView(R.layout.activity_main);
        mWv = findViewById(R.id.wv_main);
        mEt = findViewById(R.id.et_main_search);
        mBtnLeft = findViewById(R.id.btn_main_open_left_view);
        mBtnPop = findViewById(R.id.btn_main_menu);
        mBtnCollect = findViewById(R.id.btn_main_collect);
        mLv = findViewById(R.id.lv_main);
        mDl = findViewById(R.id.dl_main);
        mPb = findViewById(R.id.pb_main_progress);
        mEt.setImeOptions(EditorInfo.IME_ACTION_SEND);
        mBtnClear = findViewById(R.id.btn_layout_clear_edit_text);
        mTvMyCollections = findViewById(R.id.tv_main_my_collections);
        mBtnBottomOne = findViewById(R.id.btn_main_bottom_1);
        mBtnBottomTwo = findViewById(R.id.btn_main_bottom_2);
        mBtnBottomThree = findViewById(R.id.btn_main_bottom_3);
        mBtnBottomFour = findViewById(R.id.btn_main_bottom_4);
        mBtnBottomOne.setText(bottoms[0][0]);
        mBtnBottomTwo.setText(bottoms[1][0]);
        mBtnBottomThree.setText(bottoms[2][0]);
        mBtnBottomFour.setText(bottoms[3][0]);
        mLv.setAdapter(new ListViewAdapter(MainActivity.this, names, urls, new ListViewAdapter.IOnItemClickListener() {
            @Override
            public void onItemClick(int index) {
                mWv.loadUrl(urls[index]);
                mDl.closeDrawer(Gravity.LEFT);
            }
        }));
        userDBHelper = UserDBHelper.getInstance(MainActivity.this, 1);
        //names = userDBHelper.openReadLink().query
    }

    //初始化并且显示dialog
    void initDialog() {
        stringName = mWv.getTitle();
        stringUrl = mWv.getUrl();
        if (stringName == null) {
            stringName = "正在获取网页标题";
        }
        if (stringUrl == null) {
            stringUrl = "正在获取网页地址";
        }
        mCollectDialog = new CollectDialog(MainActivity.this, new CollectDialog.IOnCancelClickListener() {
            @Override
            public void onCancelClick() {
                mCollectDialog.cancel();
            }
        }, new CollectDialog.IOnConfirmClickListener() {
            @Override
            public void onConfirmClick() {
                stringName = mCollectDialog.getStringName();
                stringUrl = mCollectDialog.getStringUrl();

                if (!TextUtils.isEmpty(stringName) && !TextUtils.isEmpty(stringUrl)) {
                    //添加到收藏夹
                    shareWebCollect();
                    //Toast.makeText(MainActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
                    mCollectDialog.cancel();
                } else if (TextUtils.isEmpty(stringName) && TextUtils.isEmpty(stringUrl)) {
                    Toast.makeText(MainActivity.this, "请输入名称和网址", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(stringName)) {
                    Toast.makeText(MainActivity.this, "请输入名称", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "请输入网址", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mCollectDialog.setCancelable(false);
        if (TextUtils.isEmpty(stringName)) {
            mEt.setHint("正在获取网页标题");
        } else {
            mCollectDialog.setStringName(stringName);
        }
        mCollectDialog.setStringUrl(stringUrl);
        mCollectDialog.show();
    }

    //双击返回键退出
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
