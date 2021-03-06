package com.ibrahim.mohammad.entertainmentapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ibrahim.mohammad.entertainmentapp.database.AppDatabase;
import com.ibrahim.mohammad.entertainmentapp.database.User;

import java.util.List;


public class Register extends AppCompatActivity implements View.OnClickListener {

    private User user;
    private Button btnRegisterConfirm;
    private EditText etName;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private AppDatabase database;
    private int userCount;
    private int rgId;
    private int mathId;
    private String rgIdString;
    private String namew;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etRegisterName);
        etUsername = (EditText) findViewById(R.id.etRegisterUsername);
        etPassword = (EditText) findViewById(R.id.etRegisterPassword);
        etEmail = (EditText) findViewById(R.id.etRegisterEmail);

        btnRegisterConfirm = (Button) findViewById(R.id.btnRegiterConfirm);
        btnRegisterConfirm.setOnClickListener(this);

        database = AppDatabase.getDatabase(getApplicationContext());

    }


    @Override
    public void onClick(View v) {


        final String name = etName.getText().toString();
        final String username = etUsername.getText().toString();
        final String password = etPassword.getText().toString();
        final String email = etEmail.getText().toString();


        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || name.isEmpty()){
            Toast.makeText(Register.this,
                    "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else {

            List<User> users = database.userDao().getAllUser();
            userCount = users.size() + 1;
            database.userDao().addUser(new User(userCount, username, password));
            mathId = userCount -1;
            user = database.userDao().getAllUser().get(userCount-1);
            rgIdString = Integer.toString(user.id);
            pass = user.password.toString();
            namew = user.name.toString();

            Toast.makeText(Register.this, "Account created, Welcome " + username , Toast.LENGTH_LONG).show();
            Intent prefIntent = new Intent(Register.this, Homepage.class);
            String id = Integer.toString(userCount-1);
            prefIntent.putExtra("UserID", id);
            Register.this.startActivity(prefIntent);
        }



    }
}
