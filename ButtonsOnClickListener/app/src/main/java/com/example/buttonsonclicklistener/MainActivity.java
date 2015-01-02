package com.example.buttonsonclicklistener;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    Button button;
    Button anotherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        anotherButton = (Button) findViewById(R.id.button2);

        button.setOnClickListener(this);
        anotherButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            Log.d("CAB", "Button was pressed");
        } else if (v.getId() == R.id.button2) {
            Log.d("CAR", "Another Button was pressed");
        }
    }
}
