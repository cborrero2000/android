package com.eduonix.app;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.eduonix.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * entry point activity
 */
public class EduonixActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       getActionBar().setTitle("Click an Icon");

        setContentView(R.layout.entry_point_view);

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
                Intent i = new Intent(this, SimpleBundleActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }




}
