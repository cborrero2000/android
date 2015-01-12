package com.example.intentstest;

import android.util.Log;
import android.widget.Toast;

import android.content.Context;
/**
 * Created by carlos on 2015-01-11.
 */
public class L {
    public static void m(String message)
    {
        Log.d("CB", message);
    }
    public static void s(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
