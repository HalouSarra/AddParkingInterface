package com.example.addparkinginterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileParking extends AppCompatActivity {
    Button conf;
    TextView timeOpen;
    TextView timeClose;
    TextView namePark;
    TextView nbrPlace;
    TextView wilaya;
    TextView tarif;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_parking);

         timeOpen=findViewById(R.id.parkingPTimeOpen);
         timeClose=findViewById(R.id.parkingPTimeClose);
         namePark=findViewById(R.id.parkingName);
         nbrPlace=findViewById(R.id.parkingPNbrPlace);
         wilaya=findViewById(R.id.parkingWilayaPName);
         tarif=findViewById(R.id.parkingPTarifH);

        Intent intent = getIntent();
        String timeOpenText = intent.getStringExtra("timeOpen");
        String timeCloseText = intent.getStringExtra("timeClose");
        String nameParkText = intent.getStringExtra("namePark");
        String nbrPlaceText = intent.getStringExtra("nbrPlace");
        String wilayaText = intent.getStringExtra("wilaya");
        String tarifText = intent.getStringExtra("tarif");
        int latitudeValue = intent.getIntExtra("latitude", 0);
        int longitudeValue = intent.getIntExtra("longitude", 0);

        timeOpen.setText(timeOpenText);
        timeClose.setText(timeCloseText);
        namePark.setText(nameParkText);
        nbrPlace.setText(nbrPlaceText);
        wilaya.setText(wilayaText);
        tarif.setText(tarifText);

        latitude = latitudeValue;
        longitude = longitudeValue;

   }
}