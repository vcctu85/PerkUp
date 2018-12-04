package com.example.macbook.perkupapp.Adapter;

import com.example.macbook.perkupapp.R;
import com.example.macbook.perkupapp.Model.Log;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LogAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Log> movieItems;
    private Context context;
    public static final String LAST_TEXT = "";
    private SharedPreferences pref;


    public LogAdapter(Activity activity, List<Log> movieItems, Context context) {
        this.activity = activity;
        this.movieItems = movieItems;
        this.context = context;
        this.pref = PreferenceManager.getDefaultSharedPreferences(this.context);
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
        EditText personalLabel = (EditText) convertView.findViewById(R.id.personalLabel);


        // getting movie data for the row
        Log m = movieItems.get(position);

        // thumbnail image
        image.setImageResource(m.getImage());

        // title
        title.setText(m.getTitle());

        // location
        location.setText(String.valueOf(m.getLocation()));

        // date
        date.setText(m.getDate());

        //Set initial personal label
        personalLabel.setText(pref.getString(LAST_TEXT, "A cute kitty cat!"));

        personalLabel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                pref.edit().putString(LAST_TEXT, s.toString()).commit();
            }
        });

        return convertView;
    }

}
