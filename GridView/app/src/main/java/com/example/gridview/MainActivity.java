package com.example.gridview;

import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomAdapter(this));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, MyDialog.class);
        ViewHolder holder = (ViewHolder) view.getTag();
        Country country = (Country) holder.imageView.getTag();
        intent.putExtra("countryName",country.name);
        intent.putExtra("countryImage",country.image);
        startActivity(intent);
    }
}

class Country {
    String name;
    int image;

    Country(String name, int image){
        this.name = name;
        this.image = image;
    }
}

class ViewHolder {
    ImageView imageView;

    ViewHolder(View view){
        imageView = (ImageView)view.findViewById(R.id.imageView);
    }
}

class CustomAdapter extends BaseAdapter {

    ArrayList<Country> list;
    Context context;

    CustomAdapter(Context context){
        list = new ArrayList<>();
        this.context = context;

        Resources res = context.getResources();
        String [] names = res.getStringArray(R.array.country_names);
        int [] images = {
                R.drawable.bolivia,
                R.drawable.canada,
                R.drawable.czech,
                R.drawable.england,
                R.drawable.hungary,
                R.drawable.india,
                R.drawable.israel,
                R.drawable.mexico,
                R.drawable.paraguay,
                R.drawable.russia,
                R.drawable.southafrica,
                R.drawable.spain,
                R.drawable.uruguay,
                R.drawable.us,
                R.drawable.venezuela,
                R.drawable.zimbabwe
        };

        for(int i=0 ; i<16; i++){
            list.add(new Country(names[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder = null;

        if(item == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.single_item, parent, false);

            holder =  new ViewHolder(item);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        Country temp = list.get(position);
        holder.imageView.setImageResource(temp.image);
        holder.imageView.setTag(temp);

        return item;
    }
}