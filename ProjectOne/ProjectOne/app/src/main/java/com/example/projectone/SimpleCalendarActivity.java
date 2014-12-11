package com.example.projectone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by carlos on 2014-11-27.
 */
public class SimpleCalendarActivity extends Activity {

    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalendarView calendar = new CalendarView(this);
        calendar.setOnDateChangeListener(mDateSetListener);
        setContentView(calendar);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("Navigation");
    }

    private CalendarView.OnDateChangeListener mDateSetListener = new CalendarView.OnDateChangeListener(){

        public void onSelectedDayChange(CalendarView view, int year, int monthOfYear, int dayOfMonth){
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String selectedDate = new StringBuilder().append(dayOfMonth + 1).append("/").append(monthOfYear).append("/").append(year).append(" ").toString();

            Bundle b = new Bundle();
            b.putString("dateSelected", selectedDate);

            Toast.makeText(getApplicationContext(),
                    String.format("Sending cake day %d month %d year %d",mDay, mMonth, mYear), Toast.LENGTH_LONG)
                    .show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                Intent iHome = new Intent(this, SplashScreen.class);
                startActivity(iHome);
                finish();
                break;
            default:
                break;
        }
        return true;
    }
 }
