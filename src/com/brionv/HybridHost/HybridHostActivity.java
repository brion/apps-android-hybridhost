package com.brionv.HybridHost;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.*;

public class HybridHostActivity extends Activity {
    private WebView webView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        webView = (WebView)findViewById(R.id.hybridHostWebView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkLoads(false);

        webView.setWebChromeClient(new WebChromeClient() {
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return super.shouldInterceptRequest(view, url);    //To change body of overridden methods use File | Settings | File Templates.
            }
        });

        loadFirstPage();
    }

    private void loadFirstPage() {
        loadUrl("http://en.m.wikipedia.org/");
    }

    private void loadUrl(String url) {
        webView.loadUrl(url);
    }

    private void openUrlInExternalBrowser(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
