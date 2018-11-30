package com.example.macbook.perkupapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
//import com.example.macbook.perkupapp.UnityPlayerActivity;
public class GiftActivity extends Activity {
    private GiftAdapter giftAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gifts);

        ListView newsListView = findViewById(R.id.list_view);

        Gift one = new Gift(100, "Cafe Strada");

        List<Gift> gifts = new ArrayList<>();
        gifts.add(one);

        giftAdapter = new GiftAdapter(this, gifts);

        newsListView.setAdapter(giftAdapter);
    }
}
