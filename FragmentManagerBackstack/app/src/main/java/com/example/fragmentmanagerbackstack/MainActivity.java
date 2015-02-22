package com.example.fragmentmanagerbackstack;

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
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements FragmentA.OnFragmentInteractionListener, FragmentB.OnFragmentInteractionListener, FragmentManager.OnBackStackChangedListener {

    FragmentManager manager;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        text = (TextView) findViewById(R.id.textView);
        manager.addOnBackStackChangedListener(this);
    }

    public void addA(View v) {
        FragmentA fa = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, fa, "A");
        transaction.addToBackStack("addA");
        transaction.commit();
    }

    public void addB(View v) {
        FragmentB fb = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, fb, "B");
        transaction.addToBackStack("addB");
        transaction.commit();
    }

    public void removeA(View v) {

        FragmentA fa = (FragmentA) manager.findFragmentByTag("A");
        if (fa != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fa);
            transaction.addToBackStack("removeA");
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
            transaction.addToBackStack("removeB");
            transaction.commit();
        } else {
            Toast.makeText(this, "The Fragment B was not added before", Toast.LENGTH_LONG).show();
        }

    }

    public void replaceWithB(View v) {
        FragmentB fb = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group, fb, "B");
        transaction.addToBackStack("replaceWithB");
        transaction.commit();
    }

    public void replaceWithA(View v) {
        FragmentA fa = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group, fa, "A");
        transaction.addToBackStack("replaceWithA");
        transaction.commit();
    }

    public void attachA(View v) {
        FragmentA fa = (FragmentA) manager.findFragmentByTag("A");

        if (fa != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.attach(fa);
            transaction.addToBackStack("attachA");
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
            transaction.addToBackStack("detachA");
            transaction.commit();
        } else {
            Toast.makeText(this, "There was not attached Fragment A previously", Toast.LENGTH_LONG).show();
        }
    }

    public void back(View view) {
        manager.popBackStack();
    }

    public void popAddB(View view) {
        manager.popBackStack("addB", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackStackChanged() {
        text.setText(text.getText() + "\n");
        text.setText(text.getText() + "The current status of Back Stack\n");

        int counter = manager.getBackStackEntryCount();

        for (int i = counter - 1; i >= 0; i--) {
            FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(i);
            text.setText(text.getText() + " " + entry.getName() + "\n");
        }

        text.setText(text.getText() + "\n");
    }
}