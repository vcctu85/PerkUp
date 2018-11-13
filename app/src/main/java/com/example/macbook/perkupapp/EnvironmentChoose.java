package com.example.macbook.perkupapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EnvironmentChoose extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_environment);

        TextView textview = (TextView) findViewById(R.id.appLogo);// adjust this line to get the TextView you want to change
        Typeface typeface = Typeface.createFromAsset(getAssets(),"AllertaStencil-Regular.ttf"); // create a typeface from the raw ttf
        textview.setTypeface(typeface);

    }
}
