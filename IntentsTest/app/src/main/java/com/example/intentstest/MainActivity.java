package com.example.intentstest;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;


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

            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            chooser = Intent.createChooser(intent, "Launch Market");
            startActivity(chooser);

        } else if (view.getId() == R.id.sendEmail) {

            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"cborrero2000@hotmail.com", "carlos.alexander2000@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Message from Android App");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi, this is just a test");
            chooser = intent.createChooser(intent, "Send Email");
            intent.setType("message/rfc822");
            startActivity(intent);

        } else if (view.getId() == R.id.sendImage) {

            Log.d("CB", getApplicationContext().getPackageName());
            //Log.d("CB", R.drawable.ic_launcher)
            //Uri imageUri = Uri.parse("android.resource://com.example.intentstest/drawable/"+R.drawable.ic_launcher);
            Uri imageUri = Uri.parse("android.resource://com.example.intentstest/drawable/"+R.drawable.ic_launcher);
            Log.d("CB", getResources().toString());
            Log.d("CB", "imageUri[" + imageUri.toString().length() + "]");
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_TEXT, "Hi this is an image");
            chooser = Intent.createChooser(intent, "Send Image");
            startActivity(chooser);

        } else if (view.getId() == R.id.sendImages) {

            File pictures = new File("/storage/extSdCard/Images");

            //L.s(this, pictures.toString());

            /*if (pictures.exists() && pictures.isDirectory()) {
                L.s(this, "It's a directory");
            } else {
                L.s(this, "It's NO a directory");
            }*/

            String[] listOfPictures = pictures.list();
            Uri uri = null;
            ArrayList<Uri> arrayList = new ArrayList<Uri>();
            //Log.d("listOfPictures", "Size: "+ listOfPictures.length);
            for(String picture: listOfPictures) {
                //L.s(this, picture);
                //L.m(picture);
                uri = Uri.parse("file://"+ pictures.toString()+ "/" + picture);
                arrayList.add(uri);
            }

            intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, arrayList);
            intent.putExtra(Intent.EXTRA_TEXT, "I am sending multiple pictures in this intent");
            chooser = Intent.createChooser(intent, "Send Multiple Images");
            startActivity(chooser);
    }
    }
}
