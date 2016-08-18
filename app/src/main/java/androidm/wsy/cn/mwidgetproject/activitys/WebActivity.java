package androidm.wsy.cn.mwidgetproject.activitys;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidm.wsy.cn.mwidgetproject.R;
import androidm.wsy.cn.mwidgetproject.utils.ScrollerLayoutUtil;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout bottomLayout;
    private NestedScrollView nestedScrollView;
    private TextView textView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        initWeb();
    }

    private void initView() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.web_coord_layout);
        bottomLayout = (LinearLayout) findViewById(R.id.web_bottom_layout);
        nestedScrollView = (NestedScrollView) findViewById(R.id.web_nestedSv);
        textView = (TextView) findViewById(R.id.textview);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int y = (int) bottomLayout.getTranslationY();
//                bottomLayout.setTranslationY(25 + y);
            }
        });
        ScrollerLayoutUtil.delegate(nestedScrollView, bottomLayout);

    }

    private void initWeb() {
        webView = (WebView) findViewById(R.id.web_view);
        url = getIntent().getStringExtra("url");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//关键点
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(true); // 支持缩放

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);
    }
}
