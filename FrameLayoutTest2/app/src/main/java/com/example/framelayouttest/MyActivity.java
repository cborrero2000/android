package com.example.framelayouttest;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;


public class MyActivity extends Activity implements View.OnClickListener {

    ImageView i1, i2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        i1 = (ImageView) findViewById(R.id.imageView);
        i2 = (ImageView) findViewById(R.id.imageView2);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId()== R.id.imageView){
            i1.setVisibility(View.GONE);
            i2.setVisibility(View.VISIBLE);
        }
        else{
            i2.setVisibility(View.GONE);
            i1.setVisibility(View.VISIBLE);
        }

    }
}
