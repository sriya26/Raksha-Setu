package com.example.rakshasetu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Request_food extends AppCompatActivity {
     DatePicker datePicker;
     Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_food);
        datePicker = findViewById(R.id.datePicker);
        datePicker.init(2023, 3, 30, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Do something with the new data
            }
        });
         myButton = findViewById(R.id.submit);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Request Received", Toast.LENGTH_SHORT).show();
            }
        });
    }

}