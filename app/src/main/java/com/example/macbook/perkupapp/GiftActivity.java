package com.example.macbook.perkupapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//import com.example.macbook.perkupapp.UnityPlayerActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class GiftActivity extends Activity {
    private GiftAdapter giftAdapter;

    private FusedLocationProviderClient mFusedLocationClient;
    private static int REQUEST_CODE = 36;
    private Location mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gifts);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        ListView newsListView = findViewById(R.id.list_view);

        Gift one = new Gift(100, "Cafe Strada");

        List<Gift> gifts = new ArrayList<>();
        gifts.add(one);

        giftAdapter = new GiftAdapter(this, gifts);

        newsListView.setAdapter(giftAdapter);
    }

    /**
     * call getLastLocation
     */
    private void getLocation() {
        try {
            mFusedLocationClient.getLastLocation()
                    .addOnCompleteListener(this, new OnCompleteListener<Location>() {
                        @Override
                        public void onComplete(@NonNull Task<Location> task) {
                            if (task.isSuccessful() && task.getResult() != null) {
                                mLocation = task.getResult();

                            } else {

                            }
                        }
                    });
        } catch (SecurityException e) {

        }

    }



    @Override
    public void onStart() {
        super.onStart();
        int p = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (p == PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        } else {
            getLocation();
        }
    }

    /**
     * Cited: https://stackoverflow.com/questions/39781507/fused-location-provider-only-working-on-some-phones
     * @param code
     * @param permissions
     * @param results
     */
    @Override
    public void onRequestPermissionsResult(int code, @NonNull String[] permissions,
                                           @NonNull int[] results) {
        if (code == REQUEST_CODE) {
            if (results[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                startToast(R.string.warning, R.string.settings, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null);
                        intent.setData(uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    private void startToast(final int firstid, final int secondid,
                               View.OnClickListener listener) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


    private void requestLocPermissions() {
        ActivityCompat.requestPermissions(GiftActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }

    private void requestPermissions() {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            requestLocPermissions();
        } else {

            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        }
    }

}
