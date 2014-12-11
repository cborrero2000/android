package com.japp.dev1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AlertActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_layout);
        getActionBar().setHomeButtonEnabled(true);

        final TextView textViewDescription = (TextView) this.findViewById(R.id.text_view_description);
        textViewDescription.setText(getDescription());

        final ListView listViewMenu = (ListView) this.findViewById(R.id.list_view_menu_items);
        listViewMenu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getMenuItems()));
        listViewMenu.setOnItemClickListener(getMenuOnItemClickListener());

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

            default:
                break;
        }
        return true;
    }


    protected String getDescription() {
        return getResources().getString(R.string.text_alert_description);
    }


    protected String[] getMenuItems() {
        return getResources().getStringArray(R.array.alert_activity_options);
    }


    protected AdapterView.OnItemClickListener getMenuOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentView, View childView, int position, long id) {
                Intent intent = new Intent();

                switch (position) {
                    case 0:
                        // intent.setClass(parentView.getContext(), RssSyndFeedActivity.class);
                        // startActivity(intent);
                        break;
                    case 1:
                        //intent.setClass(parentView.getContext(), RssChannelActivity.class);
                        // startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };
    }
}
