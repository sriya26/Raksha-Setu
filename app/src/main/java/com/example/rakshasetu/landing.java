package com.example.rakshasetu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class landing extends AppCompatActivity  {
    ListView listView;
    Button b1;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        String[] items = {"1. Drought,Location: Bundelkhand, Rajasthan", "2. Flood, Location: Kerala", "3. Landslide,Location: Kufri, Himachal Pradesh"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, items);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        b1=findViewById(R.id.reg);
        b2=findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(landing.this,MainActivity2_login.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(landing.this,MainActivity.class);
                startActivity(intent);
            }
        });








    }

//




}