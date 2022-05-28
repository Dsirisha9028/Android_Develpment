package com.example.permissiondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int CAMERA=100;
    int SMS=101;
    Button btnCam,btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCam=findViewById(R.id.btnCam);
        btnSms=findViewById(R.id.btnSMS);
        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.CAMERA,CAMERA);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.SEND_SMS,SMS);
            }
        });
    }
    public void checkPermission(String permission,int requestCode){
        int grant= ContextCompat.checkSelfPermission(MainActivity.this,permission);
        if(grant== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {permission},requestCode);
        }
        else{
            Toast.makeText(MainActivity.this,"Permission already granted",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permission,int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permission,grantResults);
        if(requestCode==CAMERA){
            if(grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"Camera Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this,"Camera Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
        else if(requestCode==SMS){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,"SMS Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this,"SMS Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}