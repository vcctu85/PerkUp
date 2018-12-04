package com.example.macbook.perkupapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
//import com.example.macbook.perkupapp.UnityPlayerActivity;
import com.example.macbook.perkupapp.Adapter.GiftAdapter;
import com.example.macbook.perkupapp.Model.Gift;
import com.google.android.gms.location.FusedLocationProviderClient;

public class GiftActivity extends AppCompatActivity {
    private GiftAdapter giftAdapter;
    private double longitude;
    private double latitude;
    StartLocation startLocation;
    private final static int REQUEST_ACCESS_LOCATION = 1021;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gifts);
        this.startLocation = new StartLocation(this);
        requestPermissionIfNotGranted();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gifts");
    }


    public void requestPermissionIfNotGranted(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("StartPresenter", "Requesting Permission...");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_ACCESS_LOCATION);
        } else {
            startLocation.updateLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_ACCESS_LOCATION:
                startLocation.updateLocation();
                break;
        }
    }

    public void setCurrentLocation(double latitude, double longitude){
        this.longitude = longitude;
        this.latitude = latitude;

        ListView newsListView = findViewById(R.id.list_view);
        Gift one = new Gift("Caffe Strada", 37.86902282581928, -122.25483097834514);
        Gift two = new Gift("V & A Cafe", 37.87600673539823, -122.25882757455113, true);
        List<Gift> gifts = new ArrayList<>();
        gifts.add(one);
        gifts.add(two);
        for (Gift g: gifts) {
            checkLocation(g);
        }
        giftAdapter = new GiftAdapter(this, gifts);
        newsListView.setAdapter(giftAdapter);
    }


    private void checkLocation(Gift g) {
        if (g.isAtLocation() || (g.getLatitude() == latitude && g.getLongitude() == longitude)) {
            g.atLocation = true;
        } else {
            g.atLocation = false;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
//        return super.onSupportNavigateUp();
    }

}