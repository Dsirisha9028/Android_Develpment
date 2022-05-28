package com.example.intentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnopen,btncall,btnsms,btnshare;
    String phoneNumber,message;
    EditText txtMessage,txtPhoneNumber,txtURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnopen=findViewById(R.id.btnOpen);
        btncall=findViewById(R.id.btnCall);
        btnsms=findViewById(R.id.btnCalc);
        btnshare=findViewById(R.id.btnShare);
        txtMessage=findViewById(R.id.txtMessage);
        txtPhoneNumber=findViewById(R.id.txtPhone);
        txtURL=findViewById(R.id.txtURL);
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(txtURL.getText().toString()));
                    startActivity(Intent.createChooser(intent,"choose browser"));
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txtPhoneNumber.getText().toString()));
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    message=txtMessage.getText().toString();
                    phoneNumber=txtPhoneNumber.getText().toString();
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("smsto:"+phoneNumber)); //this ensures only SMS apps respond
                    intent.putExtra("sms_body",message);
                    if(intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);
                    }
                }
                catch(Exception ex){
                    Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent sendIntent=new Intent(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_TEXT,txtMessage.getText().toString());
                    Intent chooser=Intent.createChooser(sendIntent,"Share Via");
                    if(sendIntent.resolveActivity(getPackageManager())!=null){
                        startActivity(chooser);
                    }

                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}