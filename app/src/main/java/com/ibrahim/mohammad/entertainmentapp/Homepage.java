package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ibrahim.mohammad.entertainmentapp.database.Gifs;

public class Homepage extends AppCompatActivity implements View.OnClickListener{

    private BottomNavigationView bottomNavigationView;
    private Button btnVideo;
    private Button btnImages;
    private Button btnGifs;
    private String UserId;
    public String id;


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





        //bottom nav
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                //int id = Integer.parseInt(userIdnumber);
                Intent intent = getIntent();
                id = intent.getExtras().getString("UserID");

                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(Homepage.this, Homepage.class);
                        registerIntent.putExtra("UserID", "1");
                        Homepage.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Homepage.this, Notifications.class);
                        registerIntent2.putExtra("UserID", "1");
                        Homepage.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:

                      if (id.equals("guest")) {
                          Toast.makeText(Homepage.this, "Must be logged in to view Profile" + id, Toast.LENGTH_SHORT).show();
                          break;
                      }

                          Toast.makeText(Homepage.this, id, Toast.LENGTH_SHORT).show();
                          Intent registerIntent3 = new Intent(Homepage.this, Profile.class);
                          registerIntent3.putExtra("UserID", id);
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
