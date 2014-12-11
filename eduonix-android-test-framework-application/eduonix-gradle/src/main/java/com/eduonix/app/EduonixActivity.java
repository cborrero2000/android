package com.eduonix.app;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.eduonix.R;


public class EduonixActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_action_bar_menu);
        getActionBar().setTitle("Click an Icon");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_action_bar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_toast:
                Toast.makeText(this, "Toasted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_launch:
                Intent i = new Intent(this, SimpleBundleDemoActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }


}
