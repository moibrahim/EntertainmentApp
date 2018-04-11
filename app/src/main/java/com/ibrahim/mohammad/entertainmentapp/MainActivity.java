package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnGoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoHome = (Button) findViewById(R.id.btnTest);
        btnGoHome.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTest:
                Intent homepageIntent = new Intent(MainActivity.this, Postpage.class);
                MainActivity.this.startActivity(homepageIntent);
                break;

        }

    }
}
