package com.example.e_softwarica;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.e_softwarica.adapter.NoticeAdapter;
import com.example.e_softwarica.api.API;
import com.example.e_softwarica.model.NoticeReceiveParams;
import com.example.e_softwarica.network.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubActivity extends AppCompatActivity {

    ConnectionDetector cd;
    ProgressDialog progressDialog;
    CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private NoticeAdapter adapter;
    private ArrayList<NoticeReceiveParams.NoticeBean> event_list = new ArrayList<>();
    private static final String TAG = "NewsActivity";

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_news);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        cd = new ConnectionDetector(this);

        // getSupportActionBar().setTitle(R.string.small_events);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.news_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutmanager);

        // loadJSON();

        if (cd.isDataAvailable() || cd.isNetworkAvailable()) {
            loadJSON();
        }
        if (!cd.isDataAvailable() || !cd.isNetworkAvailable()) {
            progressDialog.dismiss();
            MyApplication.displaySnackbar(coordinatorLayout, ClubActivity .this);
            //Toast.makeText(getApplicationContext(),"No Internet",Toast.LENGTH_LONG).show();
        }
    }

    public void loadJSON() {

        API ptaInterface = ServiceGenerator.createRequestGsonMITRA(API.class);
        Call<NoticeReceiveParams> call = ptaInterface.getAllNotice();

        progressDialog = new ProgressDialog(ClubActivity.this);
        progressDialog.setMessage("Loading News and Events....");
        //  progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();

        call.enqueue(new Callback<NoticeReceiveParams>() {
            @Override
            public void onResponse(Call<NoticeReceiveParams> call, Response<NoticeReceiveParams> response) {
                final NoticeReceiveParams allnotice = response.body();
                event_list = new ArrayList<>(allnotice.getNotice());
                adapter = new NoticeAdapter(event_list, getApplicationContext());
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<NoticeReceiveParams> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
