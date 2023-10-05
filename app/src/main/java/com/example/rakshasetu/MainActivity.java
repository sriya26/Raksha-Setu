package com.example.rakshasetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    public String choice;
    String [] role={"Need Assistance","Volunteer/Relief Team","Donate"};
   Button b1;
   Spinner spin;
   EditText editText,fname,lname,email,pass;
   TextView atoz, AtoZ, num, charcount;
   boolean a1,a2,a3,a4;
   private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.pentry);
        atoz = findViewById(R.id.atoz);
        AtoZ = findViewById(R.id.AtoZ);
        num = findViewById(R.id.num);
        charcount = findViewById(R.id.charcount);
        fname=findViewById(R.id.fentry);
        lname=findViewById(R.id.lentry);
        email=findViewById(R.id.eentry);
        pass=findViewById(R.id.pentry);
        database = new Database(this);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener( this);
        ArrayAdapter aa= new ArrayAdapter(this, android.R.layout.simple_spinner_item,role);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        Button b1=findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the selected option from the spinner
                String selectedOption = spin.getSelectedItem().toString();
                String f=fname.getText().toString();
                String l=lname.getText().toString();
                String e=email.getText().toString();
                String p=pass.getText().toString();

                if(a1 && a2 && a3 && a4){
                    boolean em=database.check_email(e);
                    if(em) {
                        boolean res = database.insert_data(f, l, e, p, selectedOption);
                        if (res) {
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Not successful1", Toast.LENGTH_SHORT).show();
                        }
                        if (selectedOption.equals("Need Assistance")) {
                            Intent intent = new Intent(MainActivity.this, Assistance.class);
                            intent.putExtra("email",e);
                            startActivity(intent);
                        } else if (selectedOption.equals("Volunteer/Relief Team")) {
                            Intent intent = new Intent(MainActivity.this, Relief.class);
                            intent.putExtra("email",e);
                            startActivity(intent);
                        } else if (selectedOption.equals("Donate")) {
                            Intent intent = new Intent(MainActivity.this, Donate.class);
                            intent.putExtra("email",e);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Email already exists",Toast.LENGTH_SHORT).show();
                    }


                }
                else {
                   Toast.makeText(getApplicationContext(),"Invalid password",Toast.LENGTH_SHORT).show();
                }

                // open the appropriate page based on the selected option


                // add more else-if conditions for other options
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // get the password when we start typing
                String password = editText.getText().toString();
                validatepass(password);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void validatepass(String password) {

        // check for pattern
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");

        // if lowercase character is not present
        if (!lowercase.matcher(password).find()) {
            atoz.setTextColor(Color.RED);
        } else {
            // if lowercase character is  present
            atoz.setTextColor(Color.GREEN);
            a1=true;
        }

        // if uppercase character is not present
        if (!uppercase.matcher(password).find()) {
            AtoZ.setTextColor(Color.RED);
        } else {
            // if uppercase character is  present
            AtoZ.setTextColor(Color.GREEN);
            a2=true;
        }
        // if digit is not present
        if (!digit.matcher(password).find()) {
            num.setTextColor(Color.RED);
        } else {
            // if digit is present
            num.setTextColor(Color.GREEN);
            a3=true;
        }
        // if password length is less than 8
        if (password.length() < 8) {
            charcount.setTextColor(Color.RED);
        } else {
            charcount.setTextColor(Color.GREEN);
            a4=true;
        }


    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption = adapterView.getItemAtPosition(i).toString();


        }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void Log_page(View view){
        Intent intent= new Intent(this,MainActivity2_login.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed() {
        // Add your own code here if needed

        super.onBackPressed();
    }

}