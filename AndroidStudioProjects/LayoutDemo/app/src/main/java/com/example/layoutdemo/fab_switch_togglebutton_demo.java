package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class fab_switch_togglebutton_demo extends AppCompatActivity {
    FloatingActionButton fab;
    Switch aSwitch;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_switch_togglebutton_demo);
        fab=findViewById(R.id.fab);
        aSwitch=findViewById(R.id.switch1);
        toggleButton=findViewById(R.id.toggleButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Floating Action Button Pressed!",Snackbar.LENGTH_LONG).show();//snackbar always displayed on botton of screen toast
                //is displayed anywhere on the screeen
            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aSwitch.isChecked()){
                    Snackbar.make(view,"Permission Granted",Snackbar.LENGTH_LONG)
                            .setAction("Home", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getApplicationContext(),chip_chipBox_radio_image_Demo.class));
                                }
                            }).show();
                }
                else{
                    Snackbar.make(view,"Permission Revoked",Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}