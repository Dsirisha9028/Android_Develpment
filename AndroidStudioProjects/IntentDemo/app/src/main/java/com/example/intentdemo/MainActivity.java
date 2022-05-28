package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText uname,pwd;
    String user,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.btnLogin);
        uname=(EditText) findViewById(R.id.txtName);
        pwd=(EditText) findViewById(R.id.txtPwd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=uname.getText().toString();
                password=pwd.getText().toString();
                if(user.equals("student") && password.equals("student@123")){
                    Intent i=new Intent(getApplicationContext(),SecondActivity.class);
                    i.putExtra("username",uname.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid user Id of Password !",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}