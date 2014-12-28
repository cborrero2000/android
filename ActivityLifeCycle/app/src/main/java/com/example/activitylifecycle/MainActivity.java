package com.example.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFECYCLE", "OnCreate was called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE", "onStart was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE", "onResume was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "onPause was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "onStop was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECYCLE", "onRestart was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy was called");
    }

    public void finishActivity(View view) {
        finish();
    }

    public void showDialog(View view){
        Intent intent = new Intent(this, MyDialog2.class);
        startActivity(intent);
    }

    public void showActivityDialog(View view){
        Intent intent = new Intent(this, MyDialog.class);
        startActivity(intent);
    }

}