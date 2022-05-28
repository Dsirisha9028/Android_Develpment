package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
   Intent i;
   TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        i=getIntent();
        message=findViewById(R.id.txtWelcome);
        message.setText("Welcome "+i.getStringExtra("username"));
    }
}