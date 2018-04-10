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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_static_webview,null);

        wv_fire_ext_static = (WebView)view.findViewById(R.id.wv_fire_ext_static);
        wv_fire_ext_static.getSettings().setJavaScriptEnabled(true);
        wv_fire_ext_static.setWebChromeClient(new WebChromeClient());
        wv_fire_ext_static.setWebViewClient(new WebViewClient());
        wv_fire_ext_static.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);



        String url = "http://192.168.0.11/serial_monitor.php";
        loadUrl(url);
        return view;
    }

    public void loadUrl(String url){
        wv_fire_ext_static.loadUrl(url);
    }



}
