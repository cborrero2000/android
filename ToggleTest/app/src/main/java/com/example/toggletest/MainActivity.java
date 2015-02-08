package com.example.toggletest;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;


public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    RelativeLayout rl;
    ToggleButton tgl_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tgl_btn = (ToggleButton)findViewById(R.id.toggleButton);
        rl = (RelativeLayout)findViewById(R.id.layout);
        tgl_btn.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ToggleButton tb = (ToggleButton)buttonView;

        if (isChecked) {
            rl.setBackgroundColor(Color.BLACK);
        } else {
            rl.setBackgroundColor(Color.WHITE);
        }


    }
}
