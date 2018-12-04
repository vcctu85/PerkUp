package com.example.macbook.perkupapp;


import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class StartLocation {
    private FusedLocationProviderClient mFusedLocationClient;
    private Location currentLoc;
    private double mLatitudeLabel;
    private double mLongitudeLabel;
    GiftActivity ga;
    public StartLocation(GiftActivity ga) {
        this.ga = ga;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(ga);
    }

    @SuppressLint("MissingPermission")
    public void updateLocation(){
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(50);

        mFusedLocationClient.requestLocationUpdates(locationRequest, new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Location location = locationResult.getLastLocation();
                if (location != null) {
                    Log.i("StartPresenter", location.toString());
                    mLongitudeLabel = location.getLongitude();
                    mLatitudeLabel = location.getLatitude();
                    displayUpdatedLocation(location.getLatitude(), location.getLongitude());
                    mFusedLocationClient.removeLocationUpdates(this);
                } else
                    Log.e("StartPresenter", "Location == null!");
            }
        }, Looper.myLooper());
    }

    private void displayUpdatedLocation(double latitude, double longitude){
        ga.setCurrentLocation(latitude, longitude); //fallback solution
    }


}
