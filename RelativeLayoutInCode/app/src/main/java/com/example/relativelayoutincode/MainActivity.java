package com.example.relativelayoutincode;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    RelativeLayout main;
    EditText userNameValue, passwordValue;
    TextView message, userName, password;
    Button loginButton;
    RelativeLayout.LayoutParams loginMessageDimensions, userNameDimensions, userNameValueDimensions, passwordDimensions, passwordValueDimensions, loginValueDimensions;
    int messageId = 1, userNameId = 2, passwordId = 3, userNameValueId = 4, passwordValueId = 5, loginId = 6;
    int paddingValue = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        RelativeLayout.LayoutParams mainDimensions = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        main.setLayoutParams(mainDimensions);
        main.setBackgroundColor(Color.BLACK);
        createMessageTextView();
        createUserNameTextView();
        createUserNameEditText();
        createPasswordTextView();
        createPasswordEditText();
        createLoginButton();
        main.addView(message, loginMessageDimensions);
        main.addView(userName, userNameDimensions);
        main.addView(userNameValue, userNameValueDimensions);
        main.addView(password, passwordDimensions);
        main.addView(passwordValue, passwordValueDimensions);
        main.addView(loginButton, loginValueDimensions);
        setContentView(main);
    }

    public void createMessageTextView() {
        loginMessageDimensions = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        loginMessageDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        message.setPadding(paddingValue, 100, paddingValue, paddingValue);
        message.setText("Please Login First");
        //message.setTextColor(Color.WHITE);
        message.setTextColor(0xFFFFFFFF);
        message.setId(messageId);
        message.setLayoutParams(loginMessageDimensions);
    }

    public void createUserNameTextView() {
        userNameDimensions = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        userNameDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        userNameDimensions.addRule(RelativeLayout.BELOW, messageId);
        userName.setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
        userName.setLayoutParams(loginMessageDimensions);
        userName.setTextColor(0xFFFFFFFF);
        userName.setText("User Name");
        userName.setId(userNameId);
    }

    public void createUserNameEditText() {
        userNameValueDimensions = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        userNameValueDimensions.addRule(RelativeLayout.RIGHT_OF, userNameId);
        userNameValueDimensions.addRule(RelativeLayout.BELOW, messageId);
        userNameValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        userNameValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE,userNameId);
        //userNameValue.setBackgroundColor(0xFFFFFFFF);
        userNameValue.setId(userNameValueId);
    }

    public void createPasswordTextView() {
        passwordDimensions = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        passwordDimensions.addRule(RelativeLayout.BELOW, userNameValueId);
        passwordDimensions.addRule(RelativeLayout.ALIGN_RIGHT, userNameId);
        password.setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
        password.setGravity(Gravity.RIGHT);
        password.setTextColor(0xFFFFFFFF);
        password.setText("Password");
        password.setId(passwordId);

    }

    public void createPasswordEditText() {
        passwordValueDimensions = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordValueDimensions.addRule(RelativeLayout.RIGHT_OF, passwordId);
        passwordValueDimensions.addRule(RelativeLayout.BELOW, userNameValueId);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE, passwordId);
        //passwordValue.setBackgroundColor(0xFFFFFFCC);
        passwordValue.setId(passwordValueId);
    }

    public void createLoginButton() {
        loginValueDimensions = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        loginValueDimensions.addRule(RelativeLayout.BELOW, passwordValueId);
        loginValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        loginButton.setText("Login");
        loginButton.setTextColor(0xFFFFFFFF);
    }

    private void init() {
        main = new RelativeLayout(this);
        userNameValue = new EditText(this);
        passwordValue = new EditText(this);
        message = new TextView(this);
        userName = new TextView(this);
        password = new TextView(this);
        loginButton = new Button(this);
    }

}
