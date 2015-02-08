package com.example.checkboxtest;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        CheckBox cb = (CheckBox) v;

        if (cb.isChecked() == true) {
            Toast.makeText(this, "Your coffee has Sugar", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Your coffee has no Sugar", Toast.LENGTH_LONG).show();
        }
    }
}
