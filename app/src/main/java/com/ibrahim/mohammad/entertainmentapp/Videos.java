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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        videoView = (VideoView) findViewById(R.id.videoViewVids);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        mediaController = new MediaController(this);

        imageView2.setOnTouchListener(new OnSwipeTouchListener(Videos.this) {

            public void onSwipeRight() {
                Uri uri = Uri.parse("https://");
                switch (current) {
                    case "1":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                        current = "2";
                        break;
                    case "2":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
                        current = "3";
                        break;
                    case "3":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/0dp8t.mp4?token=1524361944-PGlmcKEiz2j1pLRvJ5gP0ndVKsmZifw9WrkQBrBllhg%3D");
                        current = "4";
                        break;
                    case "4":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                        current = "5";
                        break;
                    case "5":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
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
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                        current = "5";
                        break;
                    case "5":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
                        current = "4";
                        break;
                    case "4":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/0dp8t.mp4?token=1524361944-PGlmcKEiz2j1pLRvJ5gP0ndVKsmZifw9WrkQBrBllhg%3D");
                        current = "3";
                        break;
                    case "3":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                        current = "2";
                        break;
                    case "2":
                        uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
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
        database.videosDao().addVid(new com.ibrahim.mohammad.entertainmentapp.database.Videos(gifCount, "hello", "https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524360340-YhCiizZrMWP9HstoVEB2QizySqG2UIaRXZkjSc3knXk%3D"));

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
                        Videos.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Videos.this, Notifications.class);
                        Videos.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(Videos.this, Profile.class);
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
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                    current = "2";
                    break;
                case "2":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
                    current = "3";
                    break;
                case "3":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/0dp8t.mp4?token=1524361944-PGlmcKEiz2j1pLRvJ5gP0ndVKsmZifw9WrkQBrBllhg%3D");
                    current = "4";
                    break;
                case "4":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                    current = "5";
                    break;
                case "5":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
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
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                    current = "5";
                    break;
                case "5":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
                    current = "4";
                    break;
                case "4":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/0dp8t.mp4?token=1524361944-PGlmcKEiz2j1pLRvJ5gP0ndVKsmZifw9WrkQBrBllhg%3D");
                    current = "3";
                    break;
                case "3":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/up4qf.mp4?token=1524361529-qRi331becaIzgqpG5dgABJ0y%2B0R116ez0LTml0t2qPw%3D");
                    current = "2";
                    break;
                case "2":
                    uri = Uri.parse("https://cf-e2.streamablevideo.com/video/mp4/p7xh5.mp4?token=1524361855-cvHoey01UxRNubN7CuStpmTFZQddhDDnxqaNowPNSWU%3D");
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
