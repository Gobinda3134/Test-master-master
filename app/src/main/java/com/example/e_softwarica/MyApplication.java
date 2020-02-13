package com.example.e_softwarica;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.facebook.stetho.Stetho;


/**
 * Created by erasoft on 8/23/17.
 */

public class MyApplication extends Application {

  //  private FirebaseAnalytics mFirebaseAnalytics;

    public static Context app;

    @Override
    public void onCreate() {
        super.onCreate();



      /*  new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "WDFQBGCQ22ZXSHJSXDZ8");



        FontsOverride.setDefaultFont(this,"MONOSPACE","fonts/Ubuntu-R.ttf");
       // Configuration config=new Configuration.Builder(this).setDatabaseName("pta.db").create();
       //  ActiveAndroid.initialize(config);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
        mFirebaseAnalytics.setMinimumSessionDuration(6000);
        mFirebaseAnalytics.setSessionTimeoutDuration(10000);*/

        app = getApplicationContext();
       // Configuration config=new Configuration.Builder(this).setDatabaseName("esoftwarica.db").create();
       //  ActiveAndroid.initialize(config);
     // ActiveAndroid.initialize(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Stetho.initializeWithDefaults(this);
      // Stetho.initializeWithDefaults(this);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static void displaySnackbar(CoordinatorLayout coordinatorLayout, final Activity activity) {

        Snackbar.make(coordinatorLayout, "No Internet Connection", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = activity.getIntent();
                        activity.finish();
                        activity.startActivity(intent);
                    }
                }).setDuration(Snackbar.LENGTH_INDEFINITE).show();

    }

}
