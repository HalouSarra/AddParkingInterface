package com.example.addparkinginterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileParking extends AppCompatActivity {
    Button modif;
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
         modif=findViewById(R.id.btnModifier);

        Intent intent = getIntent();
        String timeOpenText = intent.getStringExtra("timeOpen");
        String timeCloseText = intent.getStringExtra("timeClose");
        String nameParkText = intent.getStringExtra("namePark");
        String nbrPlaceText = intent.getStringExtra("nbrPlace");
        String wilayaText = intent.getStringExtra("wilaya");
        String tarifText = intent.getStringExtra("tarif");
        double latitudeValue = intent.getDoubleExtra("latitude", 0);
        double longitudeValue = intent.getDoubleExtra("longitude", 0);

        timeOpen.setText(timeOpenText);
        timeClose.setText(timeCloseText);
        namePark.setText(nameParkText);
        nbrPlace.setText(nbrPlaceText);
        wilaya.setText(wilayaText);
        tarif.setText(tarifText);

        latitude = latitudeValue;
        longitude = longitudeValue;

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileParking.this, ModifieeParking.class);
                intent.putExtra("timeOpen", timeOpen.getText().toString());
                intent.putExtra("timeClose", timeClose.getText().toString());
                intent.putExtra("namePark", namePark.getText().toString());
                intent.putExtra("nbrPlace", nbrPlace.getText().toString());
                intent.putExtra("wilaya", wilaya.getText().toString());
                intent.putExtra("tarif", tarif.getText().toString());
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK && data != null) {
            String timeOpenText = data.getStringExtra("timeOpen");
            String timeCloseText = data.getStringExtra("timeClose");
            String nameParkText = data.getStringExtra("namePark");
            String nbrPlaceText = data.getStringExtra("nbrPlace");
            String wilayaText = data.getStringExtra("wilaya");
            String tarifText = data.getStringExtra("tarif");

            timeOpen.setText(timeOpenText);
            timeClose.setText(timeCloseText);
            namePark.setText(nameParkText);
            nbrPlace.setText(nbrPlaceText);
            wilaya.setText(wilayaText);
            tarif.setText(tarifText);
        }
    }
}