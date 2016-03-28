package com.photraits.photraits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ShareActionProvider;

public class MainActivity extends Activity {
    private ShareActionProvider mShareActionProvider;
    private WebView mWebView;

    /* renamed from: com.photraits.photraits.MainActivity.1 */
    class C02071 extends MyAppWebViewClient {
        C02071() {
        }

        public void onPageFinished(WebView view, String url) {
            MainActivity.this.findViewById(C0165R.id.progressBar1).setVisibility(8);
            MainActivity.this.findViewById(C0165R.id.activity_main_webview).setVisibility(0);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0165R.layout.activity_main);
        this.mWebView = (WebView) findViewById(C0165R.id.activity_main_webview);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.loadUrl("http://photraits.com/");
        this.mWebView.setWebViewClient(new C02071());
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0165R.menu.menu_main, menu);
        this.mShareActionProvider = (ShareActionProvider) menu.findItem(C0165R.id.share).getActionProvider();
        this.mShareActionProvider.setShareIntent(getDefaultShareIntent());
        return super.onCreateOptionsMenu(menu);
    }

    private Intent getDefaultShareIntent() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Photraits offers a wide range of Photographic Services");
        intent.putExtra("android.intent.extra.TEXT", " If you are in need of a photographer, kindly contact www.photraits.com or Sampath Kumar @ +919739048086");
        return intent;
    }
}
