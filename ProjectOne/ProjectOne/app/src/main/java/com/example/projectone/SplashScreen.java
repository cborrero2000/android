package com.example.projectone;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Method;

public class SplashScreen extends Activity {

    private int mImageMaxHeight;
    private int mImageMaxWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setTitle("Navigation");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mImageMaxHeight = displaymetrics.heightPixels;
        mImageMaxWidth = displaymetrics.widthPixels;
        setContentView(R.layout.activity_splash_screen);

        setLandingScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_screen_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.menu_form:
                Intent iForm = new Intent(this, FormActivity.class);
                startActivity(iForm);
                break;

            case R.id.menu_calendar:
                Intent iCalendar = new Intent(this, SimpleCalendarActivity.class);
                startActivity(iCalendar);
                break;

            default:
                break;
        }

        return true;
    }

    private void setLandingScreen(){

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.splash4, o);
        int w = bmp.getWidth();
        int h = bmp.getHeight();


        ImageView iv = (ImageView) findViewById(R.id.splash);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        params.setMargins((mImageMaxWidth-w)/2,(mImageMaxHeight-h)/2, 0, 0);
        iv.setLayoutParams(params);
        Log.v("mImageMaxHeight", "index=" + mImageMaxHeight);
        Log.v("mImageMaxWidth", "index=" + mImageMaxWidth);
        Log.v("h", "index=" + h);
        Log.v("w", "index=" + w);


        iv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        iv.requestFocus(View.FOCUS_DOWN, null);

    }

}
