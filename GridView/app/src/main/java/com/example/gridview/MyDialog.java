package com.example.gridview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MyDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        Intent intent = getIntent();

        if(intent != null) {
            String countryName = intent.getStringExtra("countryName");
            int countryImage = intent.getIntExtra("countryImage", R.drawable.india);
            ImageView imageView = (ImageView) findViewById(R.id.imageView2);
            imageView.setImageResource(countryImage);

            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("This flag belongs to " + countryName);
        }



    }

    public void closeDialog(View view){
        finish();
    }

}
