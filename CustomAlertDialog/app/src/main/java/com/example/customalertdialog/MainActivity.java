package com.example.customalertdialog;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.FileDescriptor;
import java.io.PrintWriter;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void launchDialog(View view) {
        MyAlert myAlert = new MyAlert();
        myAlert.show(getFragmentManager(), "My Alert");
    }

    public void showFragment(View view) {
        MyAlert myAlert = new MyAlert();
        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, myAlert, "My Alert Fragment");
        transaction.commit();
    }

}
