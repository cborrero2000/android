package com.example.rony.myapplication;

/**
 * Created by Rony on 11/10/2014.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // please note android.R.id.home:
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                finish();
                break;
            case R.id.calender:
                Intent calender = new Intent(this, SimpleCalenderActivity.class);
                startActivity(calender);
                finish();
                break;

            default:
                break;
        }
        return true;
    }


    public void sendFeedback(View button) {


        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        Toast.makeText(getApplicationContext(),
                String.format("Sending username %s and pasword %s", name, email), Toast.LENGTH_SHORT)
                .show();

    }

}
