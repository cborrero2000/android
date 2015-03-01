package com.example.scrollingtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    ViewPager viewPager = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }
}

class MyAdapter extends FragmentStatePagerAdapter {  // for few fragments otherwise use FragmentStatePagerAdapter

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        Log.d("CAB", "getItem is called " + i);
        switch (i) {
            case 0:
                fragment = new FragmentA();
                break;

            case 1:
                fragment = new FragmentB();
                break;

            case 2:
                fragment = new FragmentC();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        Log.d("CAB", "geCount is called");
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch(position) {
            case 0:
                return "Tab 1";
            case 1:
                return "Tab 2";
            case 2:
                return "Tab 3";
            default:
                return null;
        }
    }
}