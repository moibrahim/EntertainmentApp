package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import com.ibrahim.mohammad.entertainmentapp.database.AppDatabase;
import com.ibrahim.mohammad.entertainmentapp.database.AppDatabaseRoom3;
import com.ibrahim.mohammad.entertainmentapp.database.ImagesList;
import com.ibrahim.mohammad.entertainmentapp.database.Videos;

import java.util.List;


public class Images extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private AppDatabaseRoom3 database3;
    private ImagesList imagesList;
    private String databaseWeb;

    ListView list;
    String[] web = {
            "Image one",
            "Image two",
            "Image three",
            "Image four",
            "Image five",
            "Image six"
    } ;
    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        database3 = AppDatabaseRoom3.getDatabase(getApplicationContext());

        CustomImgList adapter = new CustomImgList(Images.this, web, imageId);
        list=(ListView)findViewById(R.id.imgListMain);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Images.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                databaseWeb = web[+position];
                SetupImagesList(databaseWeb,imageId[+position]);

            }
        });
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationImages);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(Images.this, Homepage.class);
                        Images.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Images.this, Notifications.class);
                        Images.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(Images.this, Profile.class);
                        Images.this.startActivity(registerIntent3);
                        break;


                }
                return false;
            }
        });
    }

    private void SetupImagesList(String title, Integer urlNumber) {
       // List<ImagesList> vidsList = database3.imagesDao().getAllImages();
        final int imgCount = 1;
        final String url = urlNumber.toString();
        //add video link to videos table and set it to string - video controls
        database3.imagesDao().addImages(new ImagesList(imgCount,title,url));
        Intent registerIntent4 = new Intent(Images.this, Postpage.class);
        Images.this.startActivity(registerIntent4);

    }


}

