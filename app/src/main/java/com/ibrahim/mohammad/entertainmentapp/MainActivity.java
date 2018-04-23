package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ibrahim.mohammad.entertainmentapp.database.AppDatabase;
import com.ibrahim.mohammad.entertainmentapp.database.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnGoHome;
    private Button btnRegister;
    private Button btnLogin;
    private String loginPassword;
    private String loginUsername;
    private AppDatabase database;
    private EditText etloginUsername;
    private EditText etloginPassword;
    private String passwordDatabase;
    private String usernameDatabase;
    private String idDatabase;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoHome = (Button) findViewById(R.id.btnTest);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        etloginUsername = (EditText) findViewById(R.id.etLoginUsername);
        etloginPassword = (EditText) findViewById(R.id.etLoginPassword);

        btnGoHome.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        database = AppDatabase.getDatabase(getApplicationContext());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTest:
                final String guest = "guest";
                Intent homepageIntent = new Intent(MainActivity.this, Homepage.class);
                homepageIntent.putExtra("UserID", guest);
                MainActivity.this.startActivity(homepageIntent);
                break;
            case R.id.btnRegister:
                Intent homepageIntent2 = new Intent(MainActivity.this, Register.class);
                MainActivity.this.startActivity(homepageIntent2);
                break;
            case R.id.btnLogin:

                loginPassword = etloginPassword.getText().toString();
                loginUsername = etloginUsername.getText().toString();
                boolean userfound = false;

                List<User> users = database.userDao().getAllUser();
                for(int i=0; i<users.size(); i++){
                    user = database.userDao().getAllUser().get(i);
                    usernameDatabase = user.name.toString();
                    passwordDatabase = user.password.toString();

                    if (loginPassword.equals(passwordDatabase) && loginUsername.equals(usernameDatabase)){
                        userfound = true;
                        Toast.makeText(MainActivity.this, "Logged in as " + usernameDatabase +", Welcome back!", Toast.LENGTH_LONG).show();
                        Intent loginIntent = new Intent(MainActivity.this, Homepage.class);
                        idDatabase = Integer.toString(user.id-1);
                        loginIntent.putExtra("UserID", idDatabase);
                        MainActivity.this.startActivity(loginIntent);
                    }
                    else {
                        userfound = false;
                    }

                }
                if (userfound == false){
                    userNotFound();
                }
                break;

        }

    }
    public void userNotFound(){
        Toast.makeText(MainActivity.this,
                "Login Failed, try agian", Toast.LENGTH_LONG).show();

    }
}
