package com.example.it18165180;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    EditText username, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = (EditText) findViewById(R.id.etUserNameHP);
        password = (EditText) findViewById(R.id.etPasswordHP);

        login = (Button) findViewById(R.id.btnLoginHP);
        register = (Button) findViewById(R.id.btnRegisterHP);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHP = new Intent(getApplicationContext(),ProfileManagement.class);
                startActivity(intentHP);
            }
        });
    }
}
