package com.example.rakshasetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Request_Rescue extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spin;
    String [] option={"Yes","No"};
    String chosen;
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_rescue);
        spin=findViewById(R.id.spin);
        spin.setOnItemSelectedListener( this);
        ArrayAdapter aa= new ArrayAdapter(this, android.R.layout.simple_spinner_item,option);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        myButton = findViewById(R.id.submit);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Request Received\n Rescue Team id:ABC123 is assigned to you.", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Request_Rescue.this,MapsActivity1.class);
                startActivity(i);
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption = adapterView.getItemAtPosition(i).toString();


    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
//    public void  map(){
//        Intent i=new Intent(Request_Rescue.this,MapsActivity1.class);
//        startActivity(i);
//    }
}