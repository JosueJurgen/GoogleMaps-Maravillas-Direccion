package com.example.mapas;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS){
            SupportMapFragment mapFragment = (SupportMapFragment)
                    getSupportFragmentManager()
                            .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else{

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10
                    );
            dialog.show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng Plaza = new LatLng(-13.5167684, -71.9788);
        mMap.addMarker(new MarkerOptions().position(Plaza).title("Bienvenidos a Cusco"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Plaza));
        float zooLevel = (float)  200.0;

        // Add a marker in Sydney and move the camera
        LatLng Piedra = new LatLng(-13.5160009, -71.9762526);
        mMap.addMarker(new MarkerOptions().position(Piedra).title("Piedra de los doce angulos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Piedra));

        // Add a marker in Sydney and move the camera
        LatLng Cristo = new LatLng(-13.509323550712764, -71.97819049027204);
        mMap.addMarker(new MarkerOptions().position(Cristo).title("San Cristobal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Cristo));
    }
}
