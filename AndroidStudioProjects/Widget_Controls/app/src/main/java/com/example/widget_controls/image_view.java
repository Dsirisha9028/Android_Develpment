package com.example.widget_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class image_view extends AppCompatActivity {
     RadioButton r1,r2,r3;
     ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
        imageView1=findViewById(R.id.imageView);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage();
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage();
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage();
            }
        });

    }
    private void setImage(){
        if(r1.isChecked()){
            imageView1.setImageResource(R.drawable.android);
        }
        else if(r2.isChecked()){
            imageView1.setImageResource(R.drawable.permision);
        }
        else if(r3.isChecked()){
            imageView1.setImageResource(R.drawable.mute);
        }
    }
}