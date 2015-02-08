package com.example.customfontproject;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.my_tv);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/GoodDog.otf");
        tv.setTypeface(myCustomFont);
    }
}
