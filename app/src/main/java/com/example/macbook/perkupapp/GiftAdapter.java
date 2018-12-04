package com.example.macbook.perkupapp;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class GiftAdapter extends ArrayAdapter<Gift> {

    private Context mContext;
    public GiftAdapter(Context context, List<Gift> gifts) {
        super(context, 0, gifts);
        this.mContext = context;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        TextView t = listItemView.findViewById(R.id.location);
        t.setText(getItem(position).getLocation());

        Button button = listItemView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(position).isAtLocation()) {
                    Snackbar mySnackbar = Snackbar.make(parent,
                            "While you're here, why not grab a coffee?", Snackbar.LENGTH_LONG);
                    mySnackbar.setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), com.example.macbook.perkupapp.UnityPlayerActivity.class);
                            mContext.startActivity(intent);
                        }
                    });
                    mySnackbar.show();

                } else {
                    Toast.makeText(mContext, "Make sure you're at the location!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return listItemView;
    }
}
