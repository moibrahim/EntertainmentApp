package com.ibrahim.mohammad.entertainmentapp;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;

import com.ibrahim.mohammad.entertainmentapp.database.AppDatabase;
import com.ibrahim.mohammad.entertainmentapp.database.Gifs;
import com.ibrahim.mohammad.entertainmentapp.model.OnSwipeTouchListener;

import java.util.List;

public class Videos extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private BottomNavigationView bottomNavigationView;
    private Button btnNext;
    private Button btnPrev;
    private VideoView videoView;
    private MediaController mediaController;
    private String current = "1";
    private ImageView imageView2;
    private AppDatabase database;
    private com.ibrahim.mohammad.entertainmentapp.database.Videos videos;
    private int gifCount;
    private String url;
    private String vid1;
    private String vid2;
    private String vid3;
    private String vid4;
    private String vid5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        videoView = (VideoView) findViewById(R.id.videoViewVids);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        mediaController = new MediaController(this);

        vid1 = "https://cf-e2.streamablevideo.com/video/mp4/6q6g7.mp4?token=1524784785-fkp1gyOCXMEzQ%2FdX%2FknkkIi1%2BZAYoztMLlDIeCzUhco%3D";
        vid2 = "https://cf-e2.streamablevideo.com/video/mp4/cj80y.mp4?token=1524784785-gi%2BC3%2FvQc%2FZIeW0cjM5kGt7PnvPWr9LCTwXkyKv4%2BMU%3D";
        vid3 = "https://cf-e2.streamablevideo.com/video/mp4/zxcoc.mp4?token=1524784785-rwdaGAeuu3ZN1okyUMeKwuApf39mHlUjiFSta7PhEx0%3D";
        vid4 = "https://cf-e2.streamablevideo.com/video/mp4/dwaes.mp4?token=1524784785-dMJHHU5PKt1VXfv6ZQSDnbThobMiH1nEGBVwxU9V0m8%3D";
        vid5 = "https://cf-e2.streamablevideo.com/video/mp4/jcb42.mp4?token=1524784785-U5AwHHzyP%2FE4oJsfEZ8kKDRfLY3DeQFkrB2W09h%2BaCM%3D";




        imageView2.setOnTouchListener(new OnSwipeTouchListener(Videos.this) {

            public void onSwipeRight() {
                Uri uri = Uri.parse("https://");
                switch (current) {
                    case "1":
                        uri = Uri.parse(vid2);
                        current = "2";
                        break;
                    case "2":
                        uri = Uri.parse(vid3);
                        current = "3";
                        break;
                    case "3":
                        uri = Uri.parse(vid4);
                        current = "4";
                        break;
                    case "4":
                        uri = Uri.parse(vid5);
                        current = "5";
                        break;
                    case "5":
                        uri = Uri.parse(vid1);
                        current = "1";
                        break;

                }
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
            public void onSwipeLeft() {
                Uri uri = Uri.parse("https://");
                switch (current) {
                    case "1":
                        uri = Uri.parse(vid5);
                        current = "5";
                        break;
                    case "5":
                        uri = Uri.parse(vid4);
                        current = "4";
                        break;
                    case "4":
                        uri = Uri.parse(vid3);
                        current = "3";
                        break;
                    case "3":
                        uri = Uri.parse(vid2);
                        current = "2";
                        break;
                    case "2":
                        uri = Uri.parse(vid1);
                        current = "1";
                        break;

                }
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }


        });


        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(this);


        //database set and get list of videos size
        database = AppDatabase.getDatabase(getApplicationContext());
        List<com.ibrahim.mohammad.entertainmentapp.database.Videos> vidsList = database.videosDao().getAllvids();
        gifCount = vidsList.size() + 1;
        //add video link to videos table and set it to string - video controls
        database.videosDao().addVid(new com.ibrahim.mohammad.entertainmentapp.database.Videos(gifCount, "hello", vid1));

        videos = database.videosDao().getAllvids().get(1);
        url = videos.vidUrl.toString();


        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(url);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();




        // bottom navigation controls
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationVids);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(Videos.this, Homepage.class);
                        registerIntent.putExtra("UserID", "0");
                        Videos.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Videos.this, Notifications.class);
                        registerIntent2.putExtra("UserID", "0");
                        Videos.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(Videos.this, Profile.class);
                        registerIntent3.putExtra("UserID", "0");
                        Videos.this.startActivity(registerIntent3);
                        break;


                }
                return false;
            }
        });


    }


    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("https://");

        if (v == btnNext) {
            switch (current) {
                case "1":
                    uri = Uri.parse(vid2);
                    current = "2";
                    break;
                case "2":
                    uri = Uri.parse(vid3);
                    current = "3";
                    break;
                case "3":
                    uri = Uri.parse(vid4);
                    current = "4";
                    break;
                case "4":
                    uri = Uri.parse(vid5);
                    current = "5";
                    break;
                case "5":
                    uri = Uri.parse(vid1);
                    current = "1";
                    break;

            }
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }

        if (v == btnPrev) {
            switch (current) {
                case "1":
                    uri = Uri.parse(vid5);
                    current = "5";
                    break;
                case "5":
                    uri = Uri.parse(vid4);
                    current = "4";
                    break;
                case "4":
                    uri = Uri.parse(vid3);
                    current = "3";
                    break;
                case "3":
                    uri = Uri.parse(vid2);
                    current = "2";
                    break;
                case "2":
                    uri = Uri.parse(vid1);
                    current = "1";
                    break;

            }
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
