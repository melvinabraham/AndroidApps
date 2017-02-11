package com.mapps.locationdemo;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.renderscript.Double2;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String provider;    //Store name of the provider


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        provider = locationManager.getBestProvider(new Criteria(),false);   //Get the best criteria for getting location. like incase of low battery , use previous etc. mostly decided by the device
        

        Location location = locationManager.getLastKnownLocation(provider);

        if(location!= null) {

            Log.i("location info","location achieved");


        }

        else    {

            Log.i("location info","no location");
        }


    }

    @Override
    protected void onResume()   {

        super.onResume();
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return  ;
        }
        locationManager.requestLocationUpdates(provider,400,1,this);


    }

    @Override
    public void onLocationChanged(Location location) {


        Double lat = location.getLatitude();
        Double lng = location.getLongitude();

        Log.i("Latitude",lat.toString());
        Log.i("Longitude",lng.toString());

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {


                          //User enables GPS
    }

    @Override
    public void onProviderDisabled(String s) {

                        // User disables GPS

    }

    public void getLocation(View vew)   {
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return  ;
        }

        Log.i("Click","Buttons");
        Location location = locationManager.getLastKnownLocation(provider);

        onLocationChanged(location);

    }
}
