package kr.co.isaveyou.isaveyou.issue;

import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.HttpURLConnection;

import kr.co.isaveyou.isaveyou.R;


public class Static_webViewFragment extends android.support.v4.app.Fragment {
    WebView wv_fire_ext_static;
    HttpURLConnection conn;
    WebView contentWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_static_webview,null);

        wv_fire_ext_static = (WebView)view.findViewById(R.id.wv_fire_ext_static);
//        WebSettings webSettings = contentWebView.getSettings();
        wv_fire_ext_static.getSettings().setJavaScriptEnabled(true);
        wv_fire_ext_static.setWebChromeClient(new WebChromeClient());
        wv_fire_ext_static.setWebViewClient(new WebViewClient());
        wv_fire_ext_static.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        if(Build.VERSION.SDK_INT>=21){
//            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }


        String url = "http://192.168.0.35:9999/mobile/mchart1";
        loadUrl(url);
        return view;
    }

    public void loadUrl(String url){
        wv_fire_ext_static.loadUrl(url);
    }



}
