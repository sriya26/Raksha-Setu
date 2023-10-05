package com.example.rakshasetu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String dbname = "database.db";

    public static final String f_name = "f_name";
    public static final String l_name = "l_name";
    public static final String email = "email";
    public static final String password = "password";
    public static final String type = "type";







    public Database(@Nullable Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_register = "Create table registered (f_name varchar(20), l_name varchar(20), email varchar(20),password varchar(20),type varchar(20),primary key(email))";
        sqLiteDatabase.execSQL(create_register);
        String relief_request = "Create table relief_request(email varchar(20), no_adults int,no_children int,no_infants int,med_emergency varchar(20),location varchar(20), task_num int, team_assign varchar(5),foreign key (email) references email(registered ))";
        sqLiteDatabase.execSQL(relief_request);
        String Supplies_Request = "Create table supplies_request(email varchar(20), no_adults int,no_children int,no_infants int,DOD date, location varchar(20),foreign key (email) references email(registered ))";
        sqLiteDatabase.execSQL(Supplies_Request);
        String relief_team="Create table relief_team(email varchar(20),location varchar(20), task_num int,foreign key (email) references email(registered )";
        sqLiteDatabase.execSQL(relief_team);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean insert_data(String fname, String lname, String em, String pass, String ty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(f_name, fname);
        cv.put(l_name, lname);
        cv.put(email, em);
        cv.put(password, pass);
        cv.put(type, ty);
        long res = db.insert("registered", null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean check_email(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        //String check_em = "Select * from registered where email='" + email + "'";
        Cursor cur = db.rawQuery("Select * from registered where email=?", new String[]{email});
        if (cur.getCount() > 0) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean request_rescue(String email, Integer a, Integer c, Integer i, String emergency, String location,Integer tasknum, String ta) {
        SQLiteDatabase db = this.getWritableDatabase();
        //String request_relief = "Insert into relief_request values('" + email + "'," + a + "," + c + "," + i + "," + emergency + "','" + location + "')";
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("no_adults", a);
        cv.put("no_children", c);
        cv.put("no_infants", i);
        cv.put("med_emergency", emergency);
        cv.put("location", location);
        cv.put("task_num",tasknum);
        cv.put("team_assign",ta);
        long res = db.insert("relief_request", null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
        public Boolean request_supplies (String email, Integer a, Integer c, Integer i, String date, String location){
            SQLiteDatabase db = this.getWritableDatabase();
            //String request_relief = "Insert into relief_request values('" + email + "'," + a + "," + c + "," + i + "," + emergency + "','" + location + "')";
            ContentValues cv = new ContentValues();
            cv.put("email", email);
            cv.put("no_adults", a);
            cv.put("no_children", c);
            cv.put("no_infants", i);
            cv.put("DOD", date);
            cv.put("location", location);
            long res = db.insert("supplies_request", null, cv);
            if (res == -1) {
                return false;
            } else {
                return true;
            }
    }
    public Boolean check_credentials(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur=db.rawQuery("Select password from registered where email=?",new String[]{email});
        if(cur.getCount()>0){
            if(cur.getString(0)==password){
                Cursor curr=db.rawQuery("Select type from registered where email=?",new String[]{email});


            }
        }


    }
    
    }


