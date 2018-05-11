package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Homepage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent registerIntent = new Intent(Homepage.this, Register.class);
                        Homepage.this.startActivity(registerIntent);
                        break;
                    case R.id.menu_notifications:
                        Intent registerIntent2 = new Intent(Homepage.this, MainActivity.class);
                        Homepage.this.startActivity(registerIntent2);
                        break;
                    case R.id.menu_search:
                        Intent registerIntent3 = new Intent(Homepage.this, Register.class);
                        Homepage.this.startActivity(registerIntent3);
                        break;
                }
                return false;
            }
        });

    }
}
