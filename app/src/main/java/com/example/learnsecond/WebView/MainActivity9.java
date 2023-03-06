package com.example.learnsecond.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.learnsecond.R;

public class MainActivity9 extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        webView = (WebView) findViewById(R.id.webView);

        //设置是否支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

        //1 加载internet上的网页
        //webView.loadUrl("http://www.baidu.com");

        //2 加载本地html页面,文件必须放在assets文件夹下
        //webView.loadUrl("file:///android_asset/helloworld.html");

        //3 加载数据
//        String htmlString = "<h1>Android</h1><p>Hello World!<br/></p>";
//        webView.loadData(htmlString,"text/html","utf-8");

        //在webView中点击链接时,默认情况下会打开系统浏览器,可以指定用webView还是系统浏览器打开
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("http://www.baidu.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Uri.parse(url).getHost().equals("http://www.baidu.com")) {
                    return false;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
        });
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
//            webView.goBack();
//            return true;
//        }
//        return false;
//    }
}