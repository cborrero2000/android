package com.example.edittextvalidation;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements TextWatcher {

    EditText myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (EditText) findViewById(R.id.editText);
        myText.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "before text change", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "on text change", Toast.LENGTH_LONG).show();
    }

    @Override
    public void afterTextChanged(Editable s) {
        //Toast.makeText(this, "after change", Toast.LENGTH_LONG).show();
        try {
            int no = Integer.parseInt(s.toString());

            if (no > 100) {
                s.replace(0, s.length(), "100");
            }
        } catch(NumberFormatException e) {}
    }


}
