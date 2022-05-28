package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btnMessage);
        txt1=findViewById(R.id.lblMessage);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText("Button was Clicked! ");
                Toast.makeText(getApplicationContext(),"Button was Clicked !",Toast.LENGTH_LONG).show();
            }
        });
    }
}