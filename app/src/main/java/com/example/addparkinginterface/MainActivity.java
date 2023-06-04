package com.example.addparkinginterface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {
    String[] item={ "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi","Batna","Béjaïa","Biskra","Béchar","Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen",
            "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa",
            "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf","Tissemsilt",
            "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane","Timimoun","Bordj Badji Mokhtar",
            "Ouled Djellal", "Béni Abbès", "In Salah", "Guezzam", "Touggourt","Djanet","El M'Ghair ","El Meniaa" };
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String>adapterItems;
    EditText timeOpen;
    EditText timeClose;
    private int mHour,mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeOpen=findViewById(R.id.heurOverture);
        timeClose=findViewById(R.id.heurFermiture);
        autoCompleteTextView=findViewById(R.id.autoCText);
        adapterItems= new ArrayAdapter<String>(this, R.layout.list_wilaya, item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, ""+item, Toast.LENGTH_SHORT).show();
            }
        });


        timeOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar=Calendar.getInstance();
                mHour=calendar.get(Calendar.HOUR);
                mMinute=calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
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

                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int h, int m) {
                        timeClose.setText(h+":"+m);
                    }
                },mHour,mMinute,true);
                timePickerDialog.show();

            }
        });
    }

}