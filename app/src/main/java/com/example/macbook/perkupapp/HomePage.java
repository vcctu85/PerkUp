package com.example.macbook.perkupapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;

public class HomePage extends AppCompatActivity {
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
    }

    private class chatButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomePage.this, ChatActivity.class);
            startActivity(intent);
        }
    }
    private class giftButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomePage.this, GiftActivity.class);
            startActivity(intent);
        }
    }

    private class AdventureButton implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(HomePage.this, EnvironmentChoose.class);
            startActivity(intent);
        }
    }
}
