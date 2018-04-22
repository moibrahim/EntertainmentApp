package com.ibrahim.mohammad.entertainmentapp;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.ibrahim.mohammad.entertainmentapp.database.AppDatabase;
import com.ibrahim.mohammad.entertainmentapp.database.Gifs;
import com.ibrahim.mohammad.entertainmentapp.model.Video;
import com.ibrahim.mohammad.entertainmentapp.CustomVidList;


public class GifsPage extends AppCompatActivity   implements View.OnClickListener {


    private BottomNavigationView bottomNavigationView;
    private ListView mVideosListView;
    private List<Video> mVideosList = new ArrayList<>();
    private CustomVidList mVideoAdapter;
    private Button btnPlay;
    private AppDatabase database;
    private Gifs gifs;
    private int gifCount;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifs_page);


        database = AppDatabase.getDatabase(getApplicationContext());

        List<Gifs> users = database.gifsDao().getAllgifs();
        gifCount = users.size() + 1;
        database.gifsDao().addGif(new Gifs(gifCount, "hello", "https://media.giphy.com/media/X91CkTcIUf9azs2ZtH/giphy.mp4"));

        gifs = database.gifsDao().getAllgifs().get(1);
        url = gifs.gifUrl.toString();



        //assign video
        mVideosListView = (ListView) findViewById(R.id.vidList);

        //create videos
        Video riverVideo = new Video(url);
        Video carsVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862013714.mp4");
        Video townVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862014159.mp4");
        Video whiteCarVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862014159.mp4");
        Video parkVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862014834.mp4");
        Video busyCityVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862017385.mp4");

        mVideosList.add(riverVideo);
        mVideosList.add(carsVideo);
        mVideosList.add(townVideo);
        mVideosList.add(whiteCarVideo);
        mVideosList.add(parkVideo);
        mVideosList.add(busyCityVideo);



        /***populate video list to adapter**/
        mVideoAdapter = new CustomVidList(this, mVideosList);
        mVideosListView.setAdapter(mVideoAdapter);

        mVideosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GifsPage.this,
                        "Your Message", Toast.LENGTH_LONG).show();
            }

        });
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationGifs);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(GifsPage.this, Homepage.class);
                        GifsPage.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(GifsPage.this, Profile.class);
                        GifsPage.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(GifsPage.this, Notifications.class);
                        GifsPage.this.startActivity(registerIntent3);
                        break;


                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {


    }
}

