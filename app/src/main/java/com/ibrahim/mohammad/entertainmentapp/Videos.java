package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.ibrahim.mohammad.entertainmentapp.model.Video;
import com.ibrahim.mohammad.entertainmentapp.CustomVidList;


public class Videos extends AppCompatActivity   implements View.OnClickListener {



    private ListView mVideosListView;
    private List<Video> mVideosList = new ArrayList<>();
    private CustomVidList mVideoAdapter;
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        //assign video
        mVideosListView = (ListView) findViewById(R.id.vidList);

        //create videos
        Video riverVideo = new Video("https://media.giphy.com/media/X91CkTcIUf9azs2ZtH/giphy.mp4");
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
                Toast.makeText(Videos.this,
                        "Your Message", Toast.LENGTH_LONG).show();
            }

        });


    }

    @Override
    public void onClick(View v) {


    }
}
