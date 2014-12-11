package com.example.carlosappproject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    String[] memeTitles;
    String[] memeDescriptions;
    //int[] images = {R.drawable.meme1, R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10,R.drawable.meme11,R.drawable.meme12,R.drawable.meme13,R.drawable.meme14,R.drawable.meme15};
    int[] images = {R.drawable.meme1, R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10,R.drawable.meme11,R.drawable.meme12,R.drawable.meme13,R.drawable.meme14,R.drawable.meme15,
            R.drawable.meme16, R.drawable.meme17,R.drawable.meme18,R.drawable.meme19,R.drawable.meme20,R.drawable.meme21,R.drawable.meme22,R.drawable.meme23,R.drawable.meme24,R.drawable.meme25,R.drawable.meme26,R.drawable.meme27,R.drawable.meme28};


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resource = getResources();
        memeTitles = resource.getStringArray(R.array.title);
        memeDescriptions = resource.getStringArray(R.array.description);

        listView = (ListView) findViewById(R.id.listView);
        CarlosAdapter adapter = new CarlosAdapter(this, memeTitles, images, memeDescriptions);
        listView.setAdapter(adapter);
    }
}

class CarlosAdapter extends ArrayAdapter<String> {

    Context context;
    int[] images;
    String[] titles;
    String[] desc;

    CarlosAdapter(Context c, String[] titles, int[] imgs, String[] description){
        super(c, R.layout.single_row, R.id.textView, titles);
        this.context = c;
        this.images = imgs;
        this.titles = titles;
        this.desc = description;
    }

    //LayoutInflater inflater = getLayoutInflater(); Only works inside of Activities


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // works outside of the activity
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.single_row, parent, false);

        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myTitle = (TextView) row.findViewById(R.id.textView);
        TextView myDescription = (TextView) row.findViewById(R.id.textView2);

        myImage.setImageResource(images[position]);
        myTitle.setText(titles[position]);
        myDescription.setText(desc[position]);


        return row; // you want to return an object that matches the parent
    }








}
