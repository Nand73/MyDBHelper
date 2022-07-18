package com.example.mydbhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBHelper dbhelper=new DBHelper(this);
      dbhelper.addContact("aadarsh","3924829588");
        dbhelper.addContact("Sunny","3924829478");
       dbhelper.addContact("dheeraj","3924829688");
       dbhelper.addContact("Rashmi","3924829498");

    }
}