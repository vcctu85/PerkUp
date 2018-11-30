package com.example.macbook.perkupapp;

import com.example.macbook.perkupapp.R;
import com.example.macbook.perkupapp.Model.Log;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Log> movieItems;


    public CustomListAdapter(Activity activity, List<Log> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        ImageView image = (ImageView) convertView.findViewById(R.id.giftList);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        TextView date = (TextView) convertView.findViewById(R.id.date);


        // getting movie data for the row
        Log m = movieItems.get(position);

        // thumbnail image
        image.setImageResource(m.getImage());

        // title
        title.setText(m.getTitle());

        // location
        location.setText("Location: " + String.valueOf(m.getLocation()));

        // date
        date.setText(m.getDate());

        return convertView;
    }

}
