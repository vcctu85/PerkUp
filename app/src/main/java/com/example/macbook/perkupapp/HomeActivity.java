package com.example.macbook.perkupapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button chat;
    Button giftShelf;
    Button adventureLog;

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
        chat = findViewById(R.id.chat);
        giftShelf = findViewById(R.id.giftShelf);
        adventureLog = findViewById(R.id.adventureLog);

        chat.setOnClickListener(new chatButton());
        giftShelf.setOnClickListener(new giftButton());
        adventureLog.setOnClickListener(new AdventureButton());

        getSupportActionBar().hide();
    }

    private class chatButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, ChatActivity.class);
            startActivity(intent);
        }
    }
    private class giftButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, GiftActivity.class);
            startActivity(intent);
        }
    }

    private class AdventureButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, AdventureLog.class);
            startActivity(intent);
        }
    }
}
