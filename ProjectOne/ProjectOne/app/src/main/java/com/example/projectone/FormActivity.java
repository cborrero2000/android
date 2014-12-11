package com.example.projectone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by carlos on 2014-11-27.
 */
public class FormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("Navigation");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                Intent iHome = new Intent(this, SplashScreen.class);
                startActivity(iHome);
                finish();
                break;

            case R.id.calendar:
                Intent iCalendar = new Intent(this, SimpleCalendarActivity.class);
                startActivity(iCalendar);
                finish();
                break;

            default:
                break;
        }
        return true;
    }

    public void sendFeedback(View button){

        EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        Toast.makeText(getApplicationContext(),
                String.format("Sending name %s to email %s", name, email), Toast.LENGTH_SHORT)
                .show();
    }
}
