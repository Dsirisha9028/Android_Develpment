package com.example.widgetcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class webview_demo extends AppCompatActivity {
    WebView webView1;
    Button btnOpen;
    EditText txtURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_demo);
        txtURL=findViewById(R.id.txtURL);
        btnOpen=findViewById(R.id.btnOpen);
        webView1=findViewById(R.id.webView1);
        webView1.setWebViewClient(new MyBrowser());
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=txtURL.getText().toString();
                webView1.getSettings().setLoadsImagesAutomatically(true);
                webView1.getSettings().setJavaScriptEnabled(true);
                webView1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView1.loadUrl(url);
            }
        });
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}