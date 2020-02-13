package com.example.e_softwarica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.e_softwarica.model.LattitudeLongitute;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

public class Search extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private AutoCompleteTextView etcity;
    private Button btnsearch;
    private List <LattitudeLongitute> lattitudeLongitutes;
    Marker markername;
    CameraUpdate center, zoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btnsearch=findViewById(R.id.btnsearch);
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
