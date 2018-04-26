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


public class GifsPage extends AppCompatActivity  {


    private BottomNavigationView bottomNavigationView;
    private ListView mVideosListView;
    private List<Video> mVideosList = new ArrayList<>();
    private CustomVidList mVideoAdapter;
    private Button btnPlay;
    private AppDatabase database;
    private Gifs gifs;
    private Gifs gifs2;
    private int gifCount;
    private String url;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
    private String url6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifs_page);

        database = AppDatabase.getDatabase(getApplicationContext());
        FillContent();


        String[] urlList = new String[6];
        gifs = database.gifsDao().getAllgifs().get(0);
        urlList[0] = gifs.gifUrl.toString();
        gifs = database.gifsDao().getAllgifs().get(1);
        urlList[1] = gifs.gifUrl.toString();
        gifs = database.gifsDao().getAllgifs().get(2);
        urlList[2] = gifs.gifUrl.toString();
        gifs = database.gifsDao().getAllgifs().get(3);
        urlList[3] = gifs.gifUrl.toString();
        gifs = database.gifsDao().getAllgifs().get(4);
        urlList[4] = gifs.gifUrl.toString();
        gifs = database.gifsDao().getAllgifs().get(5);
        urlList[5] = gifs.gifUrl.toString();




        //assign video
        mVideosListView = (ListView) findViewById(R.id.vidList);

        //create videos
        Video riverVideo = new Video(urlList[0]);
        Video carsVideo = new Video(urlList[1]);
        Video townVideo = new Video(urlList[2]);
        Video whiteCarVideo = new Video(urlList[3]);
        Video parkVideo = new Video(urlList[4]);
        Video busyCityVideo = new Video(urlList[5]);

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
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(GifsPage.this, "You Clicked at " , Toast.LENGTH_SHORT).show();

            }
        });

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationGifs);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(GifsPage.this, Homepage.class);
                        registerIntent.putExtra("UserID", "0");
                        GifsPage.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(GifsPage.this, Notifications.class);
                        registerIntent2.putExtra("UserID", "0");
                        GifsPage.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(GifsPage.this, Profile.class);
                        registerIntent3.putExtra("UserID", "0");
                        GifsPage.this.startActivity(registerIntent3);
                        break;


                }
                return false;
            }
        });

    }

    private void FillContent() {
        url = "https://media.giphy.com/media/X91CkTcIUf9azs2ZtH/giphy.mp4";
        url2 = "https://s3.amazonaws.com/androidvideostutorial/862013714.mp4";
        url3 = "https://s3.amazonaws.com/androidvideostutorial/862014159.mp4";
        url4 = "https://s3.amazonaws.com/androidvideostutorial/862014834.mp4";
        url5 = "https://s3.amazonaws.com/androidvideostutorial/862013714.mp4";
        url6 = "https://media.giphy.com/media/X91CkTcIUf9azs2ZtH/giphy.mp4";

        database.gifsDao().addGif(new Gifs(1, "gif1", url));
        database.gifsDao().addGif(new Gifs(2, "gif2", url2));
        database.gifsDao().addGif(new Gifs(3, "gif3", url3));
        database.gifsDao().addGif(new Gifs(4, "gif4", url4));
        database.gifsDao().addGif(new Gifs(5, "gif5", url5));
        database.gifsDao().addGif(new Gifs(6, "gif6", url6));
    }

}

