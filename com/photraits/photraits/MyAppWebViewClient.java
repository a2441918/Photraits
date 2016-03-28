package com.photraits.photraits;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyAppWebViewClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().endsWith("photraits.com")) {
            return false;
        }
        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        return true;
    }
}
