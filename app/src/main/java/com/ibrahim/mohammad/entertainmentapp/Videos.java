package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;
import android.net.Uri;

public class Videos extends AppCompatActivity implements View.OnClickListener  {

    private Button btnPlay;
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        btnPlay = (Button) findViewById(R.id.btnPlay);


        videoView = (VideoView)findViewById(R.id.videoView);
        mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r3---sn-vgqsrn7s.googlevideo.com/Cj0LENy73wIaNAmk7ghFnr-bbRMYDSANFC1hUMZaMOCoAUIASARg0Matxfei3ptZigELczltejJvVklUX0EM/5E01784BA55A48299FFE0685F4E670B73CAC9FB8.4ABD7A53717E87725B075B82EE8506F55A4D92C8/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();



        btnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                videoView.start();
                break;

        }

    }
}
