package com.devedroy.mydoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class present_location extends AppCompatActivity implements LocationListener{
    TextView home_location;
    LocationManager locationManager;
    boolean GpsStatus;
    double lat,lon;
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_location);
        home_location=findViewById(R.id.home_location);

        //location selfpermission

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext().getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) getApplicationContext(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

        //check gps permission
        CheckGpsStatus();
        getLocations();
    }

    private void getLocations() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000L, 5F, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void CheckGpsStatus() {
        locationManager = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(GpsStatus == true) {


        } else {
            Utility.showToast((Activity) getApplicationContext(),"GPS Is Disabled");
            Intent intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent1);

        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();

        try {
            Geocoder geocoder = new Geocoder(getApplicationContext().getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            address = addresses.get(0).getAddressLine(0);
            String loc=addresses.get(0).getSubLocality();
            String ecity=addresses.get(0).getLocality();
            String epin=addresses.get(0).getPostalCode();

            String eaddress=loc+","+ecity+","+epin;
//            SharedSession.insertData(getApplicationContext(), Constant.CURRENTLOC,eaddress);
//            String add=SharedSession.getStr(getApplicationContext(),Constant.CURRENTLOC);
            home_location.setText(eaddress);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}