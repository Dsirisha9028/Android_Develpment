package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Message","Activity was Created !");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message","Activity was Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message","Activity was Resumed!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message","Activity was Re-Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message","Activity was Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message","Activity was Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message","Activity was Destroyed !");
    }
}