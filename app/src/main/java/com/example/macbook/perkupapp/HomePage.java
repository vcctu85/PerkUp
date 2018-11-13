package com.example.macbook.perkupapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    Button enterAR;
    Button chatWithPenny;
    Button viewProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        init();
    }

    private void init() {


        TextView textview = (TextView) findViewById(R.id.appLogo);
        // adjust this line to get the TextView you want to change

        Typeface typeface = Typeface.createFromAsset(getAssets(),"AllertaStencil-Regular.ttf");
        // create a typeface from the raw ttf
        textview.setTypeface(typeface);

        //find three main buttons on home page.
        enterAR = findViewById(R.id.enterAR);
        chatWithPenny = findViewById(R.id.chatWithPenny);
        viewProgress = findViewById(R.id.viewProgress);

        chatWithPenny.setOnClickListener(new chatButton());
        enterAR.setOnClickListener(new ARbutton());
        viewProgress.setOnClickListener(new ProgressButton());
    }

    private class chatButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomePage.this, ChatPage.class);
            startActivity(intent);
        }
    }
    private class ARbutton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomePage.this, EnvironmentChoose.class);
            startActivity(intent);
        }
    }

    private class ProgressButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomePage.this, EnvironmentChoose.class);
            startActivity(intent);
        }
    }
}
