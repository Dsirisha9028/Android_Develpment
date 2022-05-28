package com.example.widget_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class video_view_demo extends AppCompatActivity {
    VideoView videoView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_demo);
        videoView=findViewById(R.id.videoView);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaController mediaController=new MediaController(video_view_demo.this);
                videoView.setMediaController(mediaController);
                Toast.makeText(getApplicationContext(),getPackageName(),Toast.LENGTH_SHORT).show();
                videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.androidvideo));
                mediaController.setAnchorView(videoView);
                videoView.requestFocus();
                videoView.start();
            }
        });
    }
}