package com.example.e_softwarica;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class AboutCollegeFragment extends Fragment {
    View rootView;
    WebView webView;
    String URL = "https://www.google.com/maps/place/Softwarica+College+Of+IT+%26+E-Commerce/@27.7061997,85.3278456,17z/data=!3m1!4b1!4m5!3m4!1s0x39eb190a74aa1f23:0x74ebef82ad0e5c15!8m2!3d27.706195!4d85.3300396";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle b) {
        rootView = inflater.inflate(R.layout.fragment_about_college, group, false);

        webView = rootView.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(URL);

        return rootView;
    }
}