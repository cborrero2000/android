package com.example.fragmenttransaction;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity implements FragmentA.OnFragmentInteractionListener, FragmentB.OnFragmentInteractionListener {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
    }

    public void addA(View v) {
        FragmentA fa = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, fa, "A");
        transaction.commit();
    }

    public void addB(View v) {
        FragmentB fb = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, fb, "B");
        transaction.commit();
    }

    public void removeA(View v) {

        FragmentA fa = (FragmentA) manager.findFragmentByTag("A");
        if (fa != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fa);
            transaction.commit();
        } else {
            Toast.makeText(this, "The Fragment A was not added before", Toast.LENGTH_LONG).show();
        }

    }

    public void removeB(View v) {

        FragmentB fb = (FragmentB) manager.findFragmentByTag("B");
        if (fb != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fb);
            transaction.commit();
        } else {
            Toast.makeText(this, "The Fragment B was not added before", Toast.LENGTH_LONG).show();
        }

    }

    public void replaceAWithB(View v) {
        FragmentB fb = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group, fb, "B");
        transaction.commit();
    }

    public void replaceBWithA(View v) {
        FragmentA fa = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group, fa, "A");
        transaction.commit();
    }

    public void attachA(View v) {
        FragmentA fa = (FragmentA) manager.findFragmentByTag("A");

        if (fa != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.attach(fa);
            transaction.commit();
        } else {
            Toast.makeText(this, "There was not detached Fragment A previously", Toast.LENGTH_LONG).show();
        }
    }

    public void detachA(View v) {
        FragmentA fa = (FragmentA) manager.findFragmentByTag("A");

        if (fa != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.detach(fa);
            transaction.commit();
        } else {
            Toast.makeText(this, "There was not attached Fragment A previously", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
