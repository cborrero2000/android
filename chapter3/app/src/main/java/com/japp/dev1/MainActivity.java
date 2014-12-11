package com.japp.dev1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    // AlertDialog.Builder alertDialogBuilder;
    // AlertDialog alertDialog;
    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("Chapter 3");
        setContentView(R.layout.menu_activity_layout);

        // header text
        final TextView textViewDescription = (TextView) this.findViewById(R.id.text_view_description);
        textViewDescription.setText(getDescription());

        // list select options widget
        final ListView listViewMenu = (ListView) this.findViewById(R.id.list_view_menu_items);
        listViewMenu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getMenuItems()));
        listViewMenu.setOnItemClickListener(getMenuOnItemClickListener());

    }


    protected String getDescription() {
        return getResources().getString(R.string.text_main);
    }

    //sets the names of the listViewMenu select options
    // set in Res Strings string-array  main_menu_items
    protected String[] getMenuItems() {
        return getResources().getStringArray(R.array.main_menu_items);

    }




    protected AdapterView.OnItemClickListener getMenuOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentView, View childView, int position, long id) {

                Class<?> cls = null;

                switch (position) {
                    case 0:
                        cls = AlertActivity.class;

                        break;
                    case 1:
                        cls = TravelNewsActivity.class;

                        break;
                    default:
                        break;
                }
                startActivity(new Intent(parentView.getContext(), cls));


            }
        };
    }


}
