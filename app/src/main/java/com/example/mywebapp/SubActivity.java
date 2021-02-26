package com.example.mywebapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final Context context = this;
        final Intent intent = new Intent(this, MainActivity.class);

        String url = getIntent().getStringExtra("url");

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView webview, int errorCode, String description, String failingUrl) {
                if(errorCode < 0){
                    // 自作のエラーページを表示
                    Toast.makeText(context, "Webページ読み込みエラー", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });
        webView.loadUrl(url);

//        TextView text = findViewById(R.id.text2);
//        text.setText(getIntent().getStringExtra("key"));
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
