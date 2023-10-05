package com.example.rakshasetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
import android.graphics.Color;
public class care_items extends AppCompatActivity {
 TextView pat, fb, db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//final TextView pat=(TextView)findViewById(R.id.pat);
//final TextView fb=(TextView)findViewById(R.id.fb);
//final TextView db=(TextView)findViewById(R.id.db);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Text view number 1 to add hyperlink
        pat = findViewById(R.id.pat);

// method to redirect to provided link
        pat.setMovementMethod(LinkMovementMethod.getInstance());

// method to change color of link
        pat.setLinkTextColor(Color.BLACK);

// Text view number 2 to add hyperlink
        TextView fb = findViewById(R.id.fb);

// method to redirect to provided link
        fb.setMovementMethod(LinkMovementMethod.getInstance());

// method to change color of link
        fb.setLinkTextColor(Color.BLACK);
// Text view number 2 to add hyperlink
        TextView db = findViewById(R.id.db);

// method to redirect to provided link
        db.setMovementMethod(LinkMovementMethod.getInstance());

// method to change color of link
        db.setLinkTextColor(Color.BLACK);

    }

}