package com.example.linearlayoutjavacode;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams;


public class MainActivity extends Activity {

    LinearLayout ll;
    TextView tv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ll = new LinearLayout(this);
        tv = new TextView(this);
        b = new Button(this);

        LayoutParams dimensions = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dimensions);


        LayoutParams viewDimensions = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(viewDimensions);
        b.setLayoutParams(viewDimensions);

        ll.setOrientation(LinearLayout.VERTICAL);
        tv.setText("Hello World");
        b.setText("Button here");

        ll.addView(tv);
        ll.addView(b);

        setContentView(ll);
    }



}
