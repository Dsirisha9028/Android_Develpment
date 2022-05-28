package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class auto_complete_textview extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String desig[]={"vp","regis","Director","Profeson","Assoc","Assistent","Deputy","Assistent REgister","office superinted"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_textview);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView=findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter <String> adapter=new ArrayAdapter  <String> (this, android.R.layout.simple_expandable_list_item_1,desig);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTextColor(Color.BLUE);
        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTextColor(Color.BLUE);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}