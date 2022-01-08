package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class DonationWebViewActivity extends AppCompatActivity {
    String url;
    WebView detailWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_web_view);
        detailWebView = findViewById(R.id.detailWebView);
        detailWebView.getSettings().setJavaScriptEnabled(true);
        detailWebView.setWebViewClient(new WebViewClient());
        String url = getIntent().getExtras().getString("url");
        detailWebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(detailWebView.canGoBack()){
            detailWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}