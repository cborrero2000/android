package com.example.intentstest;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.net.URI;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){

        Intent intent = null, chooser = null;

        if (view.getId() == R.id.launchMap) {

            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076, 72.8777"));
            chooser = Intent.createChooser(intent, "Launch Map");
            startActivity(chooser);

        } else if (view.getId() == R.id.launchMarket) {

        } else if (view.getId() == R.id.sendEmail) {

        }
    }

}
