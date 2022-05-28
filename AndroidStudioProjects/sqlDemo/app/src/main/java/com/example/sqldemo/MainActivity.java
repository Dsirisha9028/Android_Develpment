package com.example.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtName,txtID;
    TextView txtDisplay;
    Spinner txtProg;
    Button btnInsert,btnUpdate,btnDelete,btnList,btnCreateDB;
    SQLiteDatabase sqLiteDatabase;
    String prog[]={"BE","BTECH","BSE","BSC","MBBS","MTECH","PGDCS","MCA"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtID=findViewById(R.id.txtID);
        txtName=findViewById(R.id.txtName);
        txtProg=findViewById(R.id.txtprog);

        txtDisplay=findViewById(R.id.txtDisplay);
        btnDelete=findViewById(R.id.btnDelete);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnInsert=findViewById(R.id.btnInsert);
        btnCreateDB=findViewById(R.id.btnCreateDB);
        btnList=findViewById(R.id.btnList);
        adapter= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,prog);
        txtProg.setAdapter(adapter);
        btnCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase=openOrCreateDatabase("StudentsDB",MODE_PRIVATE,null);
                if(sqLiteDatabase!=null){
                    Toast.makeText(getApplicationContext(),"Database has been created successfully!",Toast.LENGTH_LONG).show();
                    sqLiteDatabase.execSQL("CREATE TABLE students (id INTEGER PRIMARY KEY AUTOINCREMENT,uname TEXT NOT NULL, uprog TEXT NOT NULL);");

                }
                else{
                    Toast.makeText(getApplicationContext(),"Error in Database Creation !",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase=openOrCreateDatabase("StudentsDB",MODE_PRIVATE,null);
                String name=txtName.getText().toString();
                String prog=txtProg.getSelectedItem().toString();
                ContentValues cv=new ContentValues();
                cv.put("uname",name);
                cv.put("uprog",prog);
                sqLiteDatabase.insert("students",null,cv);
                Toast.makeText(getApplicationContext(),"Record Inserted successfully",Toast.LENGTH_LONG).show();
                txtID.setText("");
                txtName.setText("");
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase=openOrCreateDatabase("StudentsDB",MODE_PRIVATE,null);
                String id=txtID.getText().toString();
                String name=txtName.getText().toString();
                String prog=txtProg.getSelectedItem().toString();
                String whereClause="id=?";
                String whereArgs[]={id};
                ContentValues cv=new ContentValues();
                cv.put("uname",name);
                cv.put("uprog",prog);
                sqLiteDatabase.update("students",cv,whereClause,whereArgs);
                Toast.makeText(getApplicationContext(),"Record updated Succesfully",Toast.LENGTH_LONG).show();
                txtName.setText("");
                txtID.setText("");
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase=openOrCreateDatabase("StudentsDB",MODE_PRIVATE,null);
                String id=txtID.getText().toString();
                String whereClause="id=?";
                String[] whereArgs ={id};
                sqLiteDatabase.delete("students",whereClause,whereArgs);
                Toast.makeText(getApplicationContext(),"Record Deleted succesfully",Toast.LENGTH_LONG).show();
                txtName.setText("");
                txtID.setText("");
            }a
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase=openOrCreateDatabase("StudentsDB",MODE_PRIVATE,null);
                String records="",uname,uprog,id;
                Cursor cursor=sqLiteDatabase.query("students",null,null,null,null,null,null);
                while(cursor.moveToNext()){
                    id=String.valueOf(cursor.getInt(0));
                    uname=cursor.getString(1);
                    uprog=cursor.getString(2);
                    records=records+id+" :"+uname+":"+uprog+"\n";
                }
                cursor.close();
                txtDisplay.setText(records);
            }
        });
    }
}