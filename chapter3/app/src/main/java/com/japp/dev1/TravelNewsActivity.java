package com.japp.dev1;


import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndEntry;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed;
import org.springframework.http.converter.feed.SyndFeedHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TravelNewsActivity extends ListActivity {

    protected static final String TAG = TravelNewsActivity.class.getSimpleName();
    private ProgressDialog progressDialog;
    private boolean destroyed = false;
    private SyndFeed feed;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setHomeButtonEnabled(true);
        setTitle("Travel News");

        // initiate the asynchronous network request
        new DownloadAtomFeedTask().execute();
    }

    @Override
    public void onStart() {
        super.onStart();
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


    // ***************************************
    // ListActivity methods
    // ***************************************
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if (feed == null) {
            return;
        }

        SyndEntry entry = (SyndEntry) feed.getEntries().get(position);
        String link = entry.getLink();
        Log.i(TAG, link);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(link));
        this.startActivity(intent);
    }

    // ***************************************
    // Private methods
    // ***************************************
    private void refreshAtomFeed(SyndFeed feed) {
        this.feed = feed;

        if (feed == null) {
            return;
        }

        setTitle(feed.getTitle());

        SyndFeedListAdapter adapter = new SyndFeedListAdapter(this, feed);

        setListAdapter(adapter);
    }

    // ***************************************
    // Private classes
    // ***************************************
    private class DownloadAtomFeedTask extends AsyncTask<Void, Void, SyndFeed> {

        @Override
        protected void onPreExecute() {
            // before the network request begins, show a progress indicator
            showLoadingProgressDialog();
        }

        @Override
        protected SyndFeed doInBackground(Void... params) {
            try {
                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate();

                // Add the SyndFeedHttpMessageConverter to the RestTemplate instance, since it is not automatically available
                restTemplate.getMessageConverters().add(new SyndFeedHttpMessageConverter());

                // The URL for making the request
                final String url = getString(R.string.atom_feed_istanbul);

                // Initiate the request and return the results.
                return restTemplate.getForObject(url, SyndFeed.class);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(SyndFeed feed) {
            // hide the progress indicator when the network request is complete
            dismissProgressDialog();

            // return the feed list
            refreshAtomFeed(feed);
        }

    }


    // ***************************************
    // Public methods
    // ***************************************
    public void showLoadingProgressDialog() {
        this.showProgressDialog("Loading. Please wait...");
    }

    public void showProgressDialog(CharSequence message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
        }

        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && !destroyed) {
            progressDialog.dismiss();
        }
    }

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyed = true;
    }


}
