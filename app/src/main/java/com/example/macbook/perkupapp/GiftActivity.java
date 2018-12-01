package com.example.macbook.perkupapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
//import com.example.macbook.perkupapp.UnityPlayerActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.example.macbook.perkupapp.StartLoc;

public class GiftActivity extends AppCompatActivity {
    private GiftAdapter giftAdapter;

    private FusedLocationProviderClient mFusedLocationClient;
    private static int REQUEST_CODE = 36;
    private Location mLocation;
    private double longitude;
    private double latitude;
    StartLoc startLoc;
    private final static int REQUEST_ACCESS_LOCATION = 1021;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gifts);
        this.startLoc = new StartLoc(this);
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
            startLoc.updateLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_ACCESS_LOCATION:
                startLoc.updateLocation();
                break;
        }
    }

    public void setCurrentLocation(double latitude, double longitude){
        this.longitude = longitude;
        this.latitude = latitude;
        System.out.println(String.valueOf(latitude) + String.valueOf(longitude));

        ListView newsListView = findViewById(R.id.list_view);
        Gift one = new Gift("Caffe Strada", "2300 College Ave, Berkeley, CA 94704", false);
        Gift two = new Gift("Jacobs Hall", "", true);
        List<Gift> gifts = new ArrayList<>();
        gifts.add(one);
        gifts.add(two);
        checkLocation(one);
        giftAdapter = new GiftAdapter(this, gifts);
        newsListView.setAdapter(giftAdapter);
    }


    private boolean checkLocation(Gift g) {
        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
//            addresses = geocoder.getFromLocation(mLocation.getLatitude(), mLocation.getLongitude(), 1);
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException io) {

        }
        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName();
        if (knownName == g.getLocation()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
//        return super.onSupportNavigateUp();
    }

}