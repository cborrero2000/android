package com.example.listviewbaseadapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class MainActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("CB","1");
        listView = (ListView) findViewById(R.id.listView);
        //Log.d("CB","2");
        listView.setAdapter(new CustomAdapter(this));
        //Log.d("CB","3");


    }
}

class SingleRow{
    String title;
    String description;
    int image;

    SingleRow(String title, String description, int image){
        this.title = title;
        this.description = description;
        this.image = image;
    }

}

class CustomAdapter extends BaseAdapter {

    ArrayList<SingleRow> arrayList;
    Context context;

    class MyViewHolder {

        ImageView image;
        TextView title;
        TextView description;

        MyViewHolder(View view){
            image = (ImageView) view.findViewById(R.id.imageView);
            title = (TextView) view.findViewById(R.id.textView);
            description = (TextView) view.findViewById(R.id.textView2);
        }
    }

    CustomAdapter(Context c){

        //Log.d("CB","CustomAdapter_Constructor");

        arrayList = new ArrayList<SingleRow>();
        context = c;
        //Log.d("CB","CustomAdapter_Constructor");
        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.title);
        String[] descriptions = res.getStringArray(R.array.description);
        //Log.d("CB","CustomAdapter_Constructor");
        int[] images = {R.drawable.meme1, R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,R.drawable.meme6,
                R.drawable.meme7, R.drawable.meme8, R.drawable.meme9,R.drawable.meme10,R.drawable.meme11,
                R.drawable.meme12,R.drawable.meme13,R.drawable.meme14,R.drawable.meme15,R.drawable.meme16,R.drawable.meme17,
                R.drawable.meme18,R.drawable.meme19,R.drawable.meme20,R.drawable.meme21,R.drawable.meme22,R.drawable.meme23,
                R.drawable.meme24,R.drawable.meme25,R.drawable.meme26,R.drawable.meme27,R.drawable.meme28};
        //Log.d("CB","CustomAdapter_Constructor");
        for(int i=0; i<28; i++){
            //Log.d("CB","CustomAdapter_Constructor i loop");
            arrayList.add(new SingleRow(titles[i], descriptions[i], images[i]));
        }
        //Log.d("CB","CustomAdapter_Constructor");
    }

    @Override
    public int getCount() {
        //Log.d("CB", "IN_getCount");
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {

        //Log.d("CB", "IN_getItem");
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Log.d("CB", "IN_getItemId");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder = null;

        //Log.d("CB", "IN_GETVIEW");

        if(convertView == null) {
            //Log.d("CB", "IN_GETVIEW_1");
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //Log.d("CB", "IN_GETVIEW_2");
            row = layoutInflater.inflate(R.layout.single_row, parent, false);
            //Log.d("CB", "IN_GETVIEW_3");
            holder = new MyViewHolder(row);
            //Log.d("CB", "IN_GETVIEW_4");
            row.setTag(holder);
            //Log.d("CB", "IN_GETVIEW_5");

        }else{
            //Log.d("CB", "IN_GETVIEW_6");
            holder = (MyViewHolder) row.getTag();
            //Log.d("CB", "IN_GETVIEW_7");
        }

        //ImageView image = (ImageView) row.findViewById(R.id.imageView);
        //TextView title = (TextView) row.findViewById(R.id.textView);
        //TextView description = (TextView) row.findViewById(R.id.textView2);
        //Log.d("CB", "IN_GETVIEW_8");
        SingleRow temp = arrayList.get(position);
        //Log.d("CB", "IN_GETVIEW_9");
        holder.image.setImageResource(temp.image);
        holder.title.setText(temp.title);
        holder.description.setText(temp.description);
        //Log.d("CB", "IN_GETVIEW_10");
        return row;
    }
}
