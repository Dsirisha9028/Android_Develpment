package com.example.layoutdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

public class chip_chipBox_radio_image_Demo extends AppCompatActivity {
    ImageButton btnImage;
    Chip btnChipMuteUnmute;
    CheckBox checkBox1,checkBox2,checkBox3;
    RadioButton optMale,optFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chip_chipbox_radio_image_demo);
        btnImage=findViewById(R.id.btnImage);
        btnChipMuteUnmute=findViewById(R.id.btnChipMuteUnMute);
        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        optFemale=findViewById(R.id.optFemale);
        optMale=findViewById(R.id.optMale);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Image Button Clicked!",Toast.LENGTH_LONG).show();
                btnImage.setImageResource(R.drawable.permision);
            }
        });
        optMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGender();
            }
        });
        optFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGender();
            }
        });
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 showHobbies();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHobbies();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHobbies();
            }
        });
        btnChipMuteUnmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChipMuteUnmute.isChecked()){
                    Toast.makeText(getApplicationContext(),"Mice Muted !",Toast.LENGTH_LONG).show();
                    btnChipMuteUnmute.setText("Unmute");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Mice Unmuted!",Toast.LENGTH_LONG).show();
                    btnChipMuteUnmute.setText("Mute");
                }
            }
        });
        btnChipMuteUnmute.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChipMuteUnmute.setVisibility(View.INVISIBLE);
            }
        });

    }
    private void showGender(){
        String message="Your Gender is:";
        if(optMale.isChecked()){
            message=message+optMale.getText();
        }
        else if(optFemale.isChecked()){
            message=message+optFemale.getText();
        }
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
    private void showHobbies(){
        String message="Hobbies are";
        if(checkBox1.isChecked()){
            message=message+checkBox1.getText()+",";
        }
        if(checkBox2.isChecked()){
            message=message+checkBox2.getText()+",";
        }
        if(checkBox3.isChecked()){
            message=message+checkBox3.getText()+",";
        }
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
