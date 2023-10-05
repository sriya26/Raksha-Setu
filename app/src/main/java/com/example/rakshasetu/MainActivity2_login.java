package com.example.rakshasetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_login);
    }
    public void Reg_page(View view){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void onBackPressed() {
        // Add your own code here if needed

        super.onBackPressed();
    }
}