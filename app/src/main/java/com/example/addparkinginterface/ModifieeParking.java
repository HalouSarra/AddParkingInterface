package com.example.addparkinginterface;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class ModifieeParking extends AppCompatActivity {
    String[] item={ "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi","Batna","Béjaïa","Biskra","Béchar","Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen",
            "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa",
            "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf","Tissemsilt",
            "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane","Timimoun","Bordj Badji Mokhtar",
            "Ouled Djellal", "Béni Abbès", "In Salah", "Guezzam", "Touggourt","Djanet","El M'Ghair ","El Meniaa" };
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String>adapterItems;
    Button conf;
    EditText timeOpen;
    EditText timeClose;
    EditText namePark;
    EditText nbrPlace;
    EditText wilaya;
    EditText tarif;
    TextInputLayout ed;
    private int mHour,mMinute;
    private static final int REQUEST_PROFILE_PARKING = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifiee_parking);
        timeOpen=findViewById(R.id.heurOvertureMod);
        timeClose=findViewById(R.id.heurFermitureMod);
        ed=findViewById(R.id.autoCTextCaseMod);
        conf=findViewById(R.id.btnConfirmationMod);
        namePark=findViewById(R.id.nomParkingMod);
        nbrPlace = findViewById(R.id.nbrPlaceMod);
        tarif=findViewById(R.id.tarifHeureMod);

        autoCompleteTextView=findViewById(R.id.autoCTextMod);
        wilaya=autoCompleteTextView;

        adapterItems= new ArrayAdapter<String>(this, R.layout.list_wilaya, item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String sItem=adapterView.getItemAtPosition(i).toString();
                ed.setHint(sItem);
            }
        });
        timeOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar=Calendar.getInstance();
                mHour=calendar.get(Calendar.HOUR);
                mMinute=calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(ModifieeParking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int h, int m) {
                        timeOpen.setText(h+":"+m);
                    }
                },mHour,mMinute,true);
                timePickerDialog.show();

            }
        });

        timeClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar=Calendar.getInstance();
                mHour=calendar.get(Calendar.HOUR);
                mMinute=calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(ModifieeParking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int h, int m) {
                        timeClose.setText(h+":"+m);
                    }
                },mHour,mMinute,true);
                timePickerDialog.show();

            }
        });


            Intent intent = getIntent();
            String timeOpenText = intent.getStringExtra("timeOpen");
            String timeCloseText = intent.getStringExtra("timeClose");
            String nameParkText = intent.getStringExtra("namePark");
            String nbrPlaceText = intent.getStringExtra("nbrPlace");
            String wilayaText = intent.getStringExtra("wilaya");
            String tarifText = intent.getStringExtra("tarif");

            timeOpen=findViewById(R.id.heurOvertureMod);
            timeClose=findViewById(R.id.heurFermitureMod);
            ed=findViewById(R.id.autoCTextCaseMod);
            conf=findViewById(R.id.btnConfirmationMod);
            namePark=findViewById(R.id.nomParkingMod);
            nbrPlace = findViewById(R.id.nbrPlaceMod);
            tarif=findViewById(R.id.tarifHeureMod);

            autoCompleteTextView=findViewById(R.id.autoCTextMod);
            wilaya=autoCompleteTextView;

            adapterItems= new ArrayAdapter<String>(this, R.layout.list_wilaya, item);
            autoCompleteTextView.setAdapter(adapterItems);
            autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String sItem=adapterView.getItemAtPosition(i).toString();
                    ed.setHint(sItem);
                }
            });

            timeOpen.setText(timeOpenText);
            timeClose.setText(timeCloseText);
            namePark.setText(nameParkText);
            nbrPlace.setText(nbrPlaceText);
            wilaya.setText(wilayaText);
            tarif.setText(tarifText);

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("timeOpen", timeOpen.getText().toString());
                intent.putExtra("timeClose", timeClose.getText().toString());
                intent.putExtra("namePark", namePark.getText().toString());
                intent.putExtra("nbrPlace", nbrPlace.getText().toString());
                intent.putExtra("wilaya", wilaya.getText().toString());
                intent.putExtra("tarif", tarif.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}