package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    int counter=0;
    Timer timer=new Timer();
    public TimerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"Service Started!",Toast.LENGTH_LONG).show();
        TimerTask tt;
        tt=new TimerTask() {
            @Override
            public void run() {
                Log.i("MyService",String.valueOf(++counter));
            }
        };
        timer.scheduleAtFixedRate(tt,0,1000);
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(timer!=null){
            timer.cancel();
        }
        Toast.makeText(this,"Service Destroyed!",Toast.LENGTH_LONG).show();
    }
}