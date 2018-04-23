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

public class Notifications extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationView;
    public String id;
    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        btnLogOut = (Button) findViewById(R.id.btnLogout);
        btnLogOut.setOnClickListener(this);
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
                        Intent registerIntent = new Intent(Notifications.this, Homepage.class);
                        registerIntent.putExtra("UserID", "1");
                        Notifications.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Notifications.this, Notifications.class);
                        registerIntent2.putExtra("UserID", "1");
                        Notifications.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_profile:

                        if (id.equals("guest")) {
                            Toast.makeText(Notifications.this, "Must be logged in to view Profile" + id, Toast.LENGTH_SHORT).show();
                            break;
                        }

                        Toast.makeText(Notifications.this, id, Toast.LENGTH_SHORT).show();
                        Intent registerIntent3 = new Intent(Notifications.this, Profile.class);
                        registerIntent3.putExtra("UserID", id);
                        Notifications.this.startActivity(registerIntent3);
                        break;

                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogout:
                Intent vidsIntent = new Intent(Notifications.this, MainActivity.class);
                Notifications.this.startActivity(vidsIntent);
                break;

        }
    }
}
