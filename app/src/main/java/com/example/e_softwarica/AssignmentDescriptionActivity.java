package com.example.e_softwarica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.e_softwarica.model.AssignmentReceiveParams;

public class AssignmentDescriptionActivity extends AppCompatActivity {

    WebView webview;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_description);

        Intent intent=getIntent();
        AssignmentReceiveParams.AssignmentBean allevents= (AssignmentReceiveParams.AssignmentBean) intent.getSerializableExtra("obj");

        webview = (WebView)findViewById(R.id.webview);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        webview.getSettings().setJavaScriptEnabled(true);
        String filename = allevents.getAssignmenturl();
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
        Intent intent = new Intent(getApplicationContext(),AssignmentActivity.class);
        startActivity(intent);
    }
}
