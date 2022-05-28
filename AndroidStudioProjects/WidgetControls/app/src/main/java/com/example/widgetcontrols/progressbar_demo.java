package com.example.widgetcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class progressbar_demo extends AppCompatActivity {
    ProgressBar progressBar;
    SeekBar seekBar;
    RatingBar ratingBar;
    Button btnStart;
    TextView txtValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_demo);
        progressBar=findViewById(R.id.progressBar);
        seekBar=findViewById(R.id.seekBar);
        ratingBar=findViewById(R.id.ratingBar);
        btnStart=findViewById(R.id.btnstart);
        txtValue=findViewById(R.id.txtvalue);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProgressValue(0);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtValue.setText("Value of Seekbar is:"+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Seekbar Touched",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"seekbar stopped moving",Toast.LENGTH_SHORT).show();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(),"Rating is "+v,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setProgressValue(final int prog){
        progressBar.setProgress(prog);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(prog<=100){
                    setProgressValue(prog+1);
                }
            }
        });
        thread.start();
    }
}