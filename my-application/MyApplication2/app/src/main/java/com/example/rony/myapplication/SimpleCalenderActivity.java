package com.example.rony.myapplication;

/**
 * Created by Rony on 11/10/2014.
 */
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;



public class SimpleCalenderActivity extends Activity {

    private int mYear;
    private int mMonth;
    private int mDay;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalendarView calendar = new CalendarView(this);
        calendar.setOnDateChangeListener(mDateSetListener);
        setContentView(calendar);
        getActionBar().setHomeButtonEnabled(true);
    }
    // the callback received when the user "sets" the date in the dialog
    private CalendarView.OnDateChangeListener mDateSetListener =
            new CalendarView.OnDateChangeListener() {

                public void onSelectedDayChange(CalendarView view, int year,
                                                int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    String selectedDate = new StringBuilder().append(mMonth + 1).append("/").append(mDay).append("/")
                            .append(mYear).append(" ").toString();
                    // cache the selected event for the activity
                    Bundle b = new Bundle();
                    b.putString("dateSelected", selectedDate);

                    Toast.makeText(getApplicationContext(),
                            String.format("Sending day %d and month %d and year %d", mDay, mMonth+1, mYear), Toast.LENGTH_LONG)
                            .show();
                }
            };
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
