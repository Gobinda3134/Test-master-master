package com.example.e_softwarica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.e_softwarica.R;
import com.example.e_softwarica.model.AssignmentReceiveParams;
import com.example.e_softwarica.model.NoticeReceiveParams;

public class NoticeDescriptionActivity extends AppCompatActivity {

    WebView webview;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_description);

        Intent intent=getIntent();
        NoticeReceiveParams.NoticeBean allnotice= (NoticeReceiveParams.NoticeBean) intent.getSerializableExtra("obj");

        webview = (WebView)findViewById(R.id.webview);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        webview.getSettings().setJavaScriptEnabled(true);
        String filename = allnotice.getNotice_url();
        webview.loadUrl("http://docs.google.com/gview?embedded=true&url=" + filename);

        webview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                progressbar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        this.finish();
        Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
        startActivity(intent);
    }
}
