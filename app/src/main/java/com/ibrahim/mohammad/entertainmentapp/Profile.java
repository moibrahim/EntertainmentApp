package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ibrahim.mohammad.entertainmentapp.database.AppDatabase;
import com.ibrahim.mohammad.entertainmentapp.database.AppDatabaseRoom2;
import com.ibrahim.mohammad.entertainmentapp.database.User;

import java.util.List;

public class Profile extends AppCompatActivity  implements View.OnClickListener{

    private BottomNavigationView bottomNavigationView;
    private com.ibrahim.mohammad.entertainmentapp.database.Profile profile;
    private User user;
    private AppDatabase database;
    private AppDatabaseRoom2 database2;
    private Button btnSavedpost;
    private Button btnComments;
    private Button btnMsgs;
    private ImageButton btnSettings;
    private ImageButton btnEditAcc;
    private TextView profilUsername;
    private String rating;
    private String savedPost;
    private int count;
    private int dateJoinedAge;
    private int numberOfComments;
    private int numberOfPostsSaved;
    private String username;
    private String status;
    private String savedPost2;
    private String comments;
    private String msgs;
    private String userIdnumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        Intent intent = getIntent();
        userIdnumber = intent.getExtras().getString("UserID");

        if (userIdnumber.equals("")){
            Toast.makeText(Profile.this, "No ID", Toast.LENGTH_LONG).show();
        }

        else {
            int id = Integer.parseInt(userIdnumber);
        }

        btnSavedpost = (Button) findViewById(R.id.btnSavedpost);
        btnSavedpost.setOnClickListener(this);
        btnComments = (Button) findViewById(R.id.btnComments);
        btnComments.setOnClickListener(this);
        btnMsgs = (Button) findViewById(R.id.btnMessages);
        btnMsgs.setOnClickListener(this);
        btnSettings = (ImageButton) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(this);
        btnEditAcc = (ImageButton) findViewById(R.id.btnEditAcc);
        btnEditAcc.setOnClickListener(this);

        profilUsername = (TextView) findViewById(R.id.tvUsernameProfile);
        status = "new";savedPost = "";savedPost2 = "";comments = ""; msgs="";

        database = AppDatabase.getDatabase(getApplicationContext());
        database2 = AppDatabaseRoom2.getDatabase(getApplicationContext());


        //bottom nav
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(Profile.this, Homepage.class);
                        registerIntent.putExtra("UserID", userIdnumber);
                        Profile.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Profile.this, Notifications.class);
                        registerIntent2.putExtra("UserID", userIdnumber);
                        Profile.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:
                        Intent registerIntent3 = new Intent(Profile.this, Profile.class);
                        registerIntent3.putExtra("UserID", userIdnumber);
                        Profile.this.startActivity(registerIntent3);
                        break;
                }
                return false;
            }
        });




            if (userIdnumber.equals("")){
                Toast.makeText(Profile.this, "No ID", Toast.LENGTH_LONG).show();
                }

            else {
                int id = Integer.parseInt(userIdnumber);
                user = database.userDao().getAllUser().get(id);
                username = user.name.toString();
                profilUsername.setText(username);
            }

        setProfile(status,savedPost,savedPost2);
    }


    public void setProfile(String status,String savedPost, String savedPost2) {

        final String defualtrating = "3.5";

        if (status.equals("new")){
            List<com.ibrahim.mohammad.entertainmentapp.database.Profile> profileList = database2.profileDao().getAllProfile();
            count = profileList.size()+1;
            database2.profileDao().addProfile(new com.ibrahim.mohammad.entertainmentapp.database.Profile(count,defualtrating,savedPost,savedPost2));
            profile = database2.profileDao().getAllProfile().get(count-1);
            rating = profile.rating.toString();
            RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
            simpleRatingBar.setRating(Float.parseFloat(rating));
        }
        else {
            CalculateRating(dateJoinedAge,numberOfPostsSaved,numberOfComments);
        }


    }

    private void CalculateRating(int age,int posts,int comments) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSavedpost:
                if (savedPost.equals("") ||savedPost2.equals("") ){
                    Toast.makeText(Profile.this, "There are currently no saved post", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    List<com.ibrahim.mohammad.entertainmentapp.database.Profile> profileList = database2.profileDao().getAllProfile();
                    count = profileList.size()+1;
                    profile = database2.profileDao().getAllProfile().get(count-1);
                    final String savedpostAll = profile.savedPost.toString();
                    break;
                }
            case R.id.btnComments:
                if (comments.equals("") ){
                    Toast.makeText(Profile.this, "There are currently no comments", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    final String commentUpload = comments;
                    break;
                }
            case R.id.btnMessages:
                if (msgs.equals("") ){
                    Toast.makeText(Profile.this, "There are currently no messages", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    List<com.ibrahim.mohammad.entertainmentapp.database.Profile> profileList = database2.profileDao().getAllProfile();
                    count = profileList.size()+1;
                    profile = database2.profileDao().getAllProfile().get(count-1);
                    final String allMsgs = msgs;
                    break;
                }
            case R.id.btnSettings:
                Intent settingAccIntent = new Intent(Profile.this, Notifications.class);
                Profile.this.startActivity(settingAccIntent);
                break;

            case R.id.btnEditAcc:
                Intent editAccIntent = new Intent(Profile.this, Register.class);
                Profile.this.startActivity(editAccIntent);
                break;

        }
    }
}
