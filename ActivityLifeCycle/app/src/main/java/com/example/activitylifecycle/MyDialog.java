package com.example.activitylifecycle;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
    }

    public void closeActivity(View view){
        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("ORIENTATION", "Screen Orientation changed");

        Log.d("ORIENTATION", "" + newConfig.orientation);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("ORIENTATION", "Welcome to landscape orientation");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("ORIENTATION", "Welcome to portrait orientation");
        }
    }
}
