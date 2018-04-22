package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ibrahim.mohammad.entertainmentapp.database.Gifs;

public class Homepage extends AppCompatActivity implements View.OnClickListener{

    private BottomNavigationView bottomNavigationView;
    private Button btnVideo;
    private Button btnImages;
    private Button btnGifs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnVideo = (Button) findViewById(R.id.btnVideos);
        btnVideo.setOnClickListener(this);
        btnImages = (Button) findViewById(R.id.btnImages);
        btnImages.setOnClickListener(this);
        btnGifs = (Button) findViewById(R.id.btnGifs);
        btnGifs.setOnClickListener(this);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(Homepage.this, Homepage.class);
                        Homepage.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Homepage.this, Notifications.class);
                        Homepage.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(Homepage.this, Profile.class);
                        Homepage.this.startActivity(registerIntent3);
                        break;


                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
                case R.id.btnVideos:
                    Intent vidsIntent = new Intent(Homepage.this, Videos.class);
                    Homepage.this.startActivity(vidsIntent);
                    break;
                case R.id.btnImages:
                    Intent imgIntent = new Intent(Homepage.this, Images.class);
                    Homepage.this.startActivity(imgIntent);
                    break;
            case R.id.btnGifs:
                Intent gifIntent = new Intent(Homepage.this, GifsPage.class);
                Homepage.this.startActivity(gifIntent);
                break;
        }

    }
}
