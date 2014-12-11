package com.japp.dev1;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndEntry;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed;

public class SyndFeedListAdapter extends BaseAdapter {

    private SyndFeed syndFeed;
    private final LayoutInflater layoutInflater;


    public SyndFeedListAdapter(Context context, SyndFeed feed) {
        this.syndFeed = feed;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return syndFeed != null ? syndFeed.getEntries().size() : 0;
    }

    public SyndEntry getItem(int position) {
        return (SyndEntry) syndFeed.getEntries().get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SyndEntry syndEntry = getItem(position);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.synd_feed_list_item, parent, false);
        }

        if (syndEntry != null) {
            TextView textView;
            if (syndEntry.getTitle() != null) {
                textView = (TextView) convertView.findViewById(R.id.synd_feed_title);
                textView.setText(syndEntry.getTitle());
            }
            if (syndEntry.getPublishedDate() != null) {
                textView = (TextView) convertView.findViewById(R.id.synd_feed_date);
                textView.setText(syndEntry.getPublishedDate().toString());
            }
            if (syndEntry.getDescription() != null) {
                textView = (TextView) convertView.findViewById(R.id.synd_feed_description);
                textView.setText(Html.fromHtml(syndEntry.getDescription().getValue(), new ImageGetter(), null));
            }
        }

        return convertView;
    }

    // Html.fromHtml(htmlText, new ImageGetter(), null)

    private class ImageGetter implements Html.ImageGetter {

        public Drawable getDrawable(String source) {

            return null;

        }
    }

    ;

}
