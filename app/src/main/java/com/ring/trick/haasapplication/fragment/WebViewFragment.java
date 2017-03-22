package com.ring.trick.haasapplication.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ring.trick.haasapplication.R;
import com.ring.trick.haasapplication.databinding.FragmentWebViewBinding;

public class WebViewFragment extends Fragment {

    private static final String TAG = WebViewFragment.class.getSimpleName();

    private static final String BUNDLE_OPEN_URL = "com.ring.trick.BUNDLE_OPEN_URL";

    private String openUrl;

    private FragmentWebViewBinding binding;

    public static WebViewFragment newInstance(@NonNull String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_OPEN_URL, url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            openUrl = getArguments().getString(BUNDLE_OPEN_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated:" + savedInstanceState);
        super.onActivityCreated(savedInstanceState);
        binding = FragmentWebViewBinding.bind(getView());
        if (savedInstanceState == null) {
            initWebView(binding.webView).loadUrl(openUrl);
        } else {
            binding.webView.restoreState(savedInstanceState);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private WebView initWebView(WebView webView) {
        if (webView == null) {
            return null;
        }
        // スクロールバーを表示
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        // JS有効化
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new CustomWebViewClient());
        return webView;
    }

    private ProgressDialog createProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("読み込んでいます...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressDialog;
    }

    private class CustomWebViewClient extends WebViewClient {

        private ProgressDialog progressDialog;

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.d(TAG, "新しいURLが指定");
            return false;
        }

        // 新しいURLが指定されたときの処理を定義
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(TAG, "新しいURLが指定");
            if (progressDialog == null) {
                progressDialog = createProgressDialog();
            }
            progressDialog.show();

            // 別のActivityやアプリを起動する場合
            //return true;
            // WebView内に読み込み結果を表示する場合
            return false;
        }

        // ページ読み込み開始時の処理
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d(TAG, "ページ読み込み開始");
            if (progressDialog == null) {
                progressDialog = createProgressDialog();
            }
            progressDialog.show();
        }

        // ページ読み込み完了時の処理
        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d(TAG, "ページ読み込み完了");
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            if (request.isForMainFrame()) {
                Log.d(TAG, "ページ読み込みエラー");
            }
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }

        // ページ読み込みエラー時の処理
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String url) {
            Log.d(TAG, "ページ読み込みエラー");
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }

    }
}