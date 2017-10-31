package com.mangobloggerandroid.app.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.mangobloggerandroid.app.R;
import com.mangobloggerandroid.app.util.MyWebViewClient;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by ujjawal on 31/10/17.
 */

public class LoginWebViewActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private WebView mWebView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String mUrl;
    private String mTag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_web);
        mUrl = "https://www.mangoblogger.com/my-account/";

        mWebView = (WebView) findViewById(R.id.webview);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        mWebView.setWebViewClient(new MyWebViewClient(this));
        // enable javascript
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(mUrl);
        // enable caching
//        enableCache();
        // enable back key press
//        enableBackKeyPressed();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWebView.loadUrl(mWebView.getUrl());
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                super.onProgressChanged(view, progress);
                if(mProgressBar != null) {
                    mProgressBar.setProgress(progress);
                    mProgressBar.setVisibility(progress == 100 ? GONE : VISIBLE);
                }
                if(mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(!(progress == 100));
                }
            }
        });
    }
}
