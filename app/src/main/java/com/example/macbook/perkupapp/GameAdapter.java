package com.example.macbook.perkupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GameAdapter extends ArrayAdapter<Game> {
    public GameAdapter(Context context, List<Game> games) {
        super(context, 0, games);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Game currentGame = getItem(position);
        TextView points = listItemView.findViewById(R.id.points);
        TextView location = listItemView.findViewById(R.id.location);


        points.setText("Earn " + Integer.toString(currentGame.getNumPoints()) + " points at");
        location.setText(currentGame.getLocation());

        return listItemView;
    }
}
