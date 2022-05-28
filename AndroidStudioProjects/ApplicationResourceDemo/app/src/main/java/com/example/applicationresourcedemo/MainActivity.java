package com.example.applicationresourcedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnChangeImage,btnChangeColor,btnChangeText;
    TextView txtMessage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeImage=findViewById(R.id.btnChangeImage);
        btnChangeColor=findViewById(R.id.btnChangeColor);
        btnChangeText=findViewById(R.id.btnChangeText);
        imageView=findViewById(R.id.imageView);
        txtMessage=findViewById(R.id.txtMessage);
        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.permision);
            }
        });
        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setText(R.string.message2);
            }
        });
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setTextColor(getResources().getColor(R.color.red));
            }
        });
    }
}