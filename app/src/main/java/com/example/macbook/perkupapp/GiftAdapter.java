package com.example.macbook.perkupapp;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class GiftAdapter extends ArrayAdapter<Gift> {
    private Context mContext;
    public GiftAdapter(Context context, List<Gift> gifts) {
        super(context, 0, gifts);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Gift currentGift = getItem(position);
        TextView points = listItemView.findViewById(R.id.points);
        TextView location = listItemView.findViewById(R.id.location);

        Button button = listItemView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mContext.startActivity(intent);
            }
        });
        points.setText("Earn " + Integer.toString(currentGift.getNumPoints()) + " points at");
        location.setText(currentGift.getLocation());

        return listItemView;
    }
}
