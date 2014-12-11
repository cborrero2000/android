package com.example.rony.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.rony.myapplication.R;
public class MainActivity extends Activity {

    private int mImageMaxWidth;
    private int mImageMaxHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // this splash screen should be a blank slate
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getActionBar().setTitle("Navigation");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mImageMaxHeight = displaymetrics.heightPixels;
        mImageMaxWidth = displaymetrics.widthPixels;
        setContentView(R.layout.entry_point_view);


        setLandingScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.entry_point_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_form:
                Intent iForm = new Intent(this, FormActivity.class);
                startActivity(iForm);
                break;
            case R.id.menu_launch:
                Intent i = new Intent(this, SimpleCalenderActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }

    private void setLandingScreen() {

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.splash2/*learning*/, o);
        int w = bmp.getWidth();
        int h = bmp.getHeight();

        // add items to the splash screen here. makes things less distracting.
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
        Log.v("o.inTargetDensity", "inTargetDensity=" + o.inTargetDensity);

        //iv.setVisibility(View.DRAWING_CACHE_QUALITY_LOW);
        //iv.setVisibility(View.FOCUS_DOWN);

        iv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        iv.requestFocus(View.FOCUS_DOWN, null);

        StringBuffer buf = new StringBuffer();

        buf.append("VERSION.RELEASE {"+Build.VERSION.RELEASE+"}");
        buf.append("\\nVERSION.INCREMENTAL {"+Build.VERSION.INCREMENTAL+"}");
        buf.append("\\nVERSION.SDK {"+Build.VERSION.SDK+"}");
        buf.append("\\nBOARD {"+Build.BOARD+"}");
        buf.append("\\nBRAND {"+Build.BRAND+"}");
        buf.append("\\nDEVICE {"+Build.DEVICE+"}");
        buf.append("\\nFINGERPRINT {"+ Build.FINGERPRINT+"}");
        buf.append("\\nHOST {"+Build.HOST+"}");
        buf.append("\\nID {"+Build.ID+"}");

        Log.d("build",buf.toString());



    }


}
