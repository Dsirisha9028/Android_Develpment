package com.example.displaycontacts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> allcontacts;
    ArrayAdapter<String> arrayAdapter;
    Cursor cursor;
    String name,phone;
    final int RequestPermissionCode=1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView1);
        button=findViewById(R.id.button1);
        allcontacts=new ArrayList<String>();
        EnableRuntimePermission();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetContactIntoArrayList();
                arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,allcontacts);
                listView.setAdapter(arrayAdapter);
            }
        });
    }
    @SuppressLint("Range")
    public void GetContactIntoArrayList(){
        cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while(cursor.moveToNext()){
            name=cursor.getString(cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            ));
            phone=cursor.getString(cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER
            ));
            allcontacts.add(name+":"+phone);
        }
        cursor.close();
    }
    public void EnableRuntimePermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                MainActivity.this, Manifest.permission.READ_CONTACTS
        )){
            Toast.makeText(MainActivity.this,"Contacts permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();
        }
        else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.READ_CONTACTS
            }, RequestPermissionCode);
        }
    }

    private void onRequestPermissionResult(int RC, String per[], int[] PResult){
        super.onRequestPermissionsResult(RC,per,PResult);
        switch(RC){
            case RequestPermissionCode:
                    if(PResult.length>0 && PResult[0]== PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(
                                MainActivity.this,
                                "Permission Granted,Now your application can access CONTACTS",
                                Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(MainActivity.this,"permission Revoked, NOw your application cannot access contacts",Toast.LENGTH_LONG).show();
                    }
        }
    }

}