package com.example.it18165180;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.it18165180.Database.DBHandler;

public class ProfileManagement extends AppCompatActivity {

    EditText username, dob, password;
    Button add, updateProfile;
    RadioButton male, female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = (EditText) findViewById(R.id.etUserNamePM);
        dob = (EditText) findViewById(R.id.etDobPM);
        password = (EditText) findViewById(R.id.etPasswordPM);

        male = (RadioButton) findViewById(R.id.radioButton2);
        female = (RadioButton) findViewById(R.id.radioButton3);

        add = (Button) findViewById(R.id.btnAddPM);
        updateProfile = (Button) findViewById(R.id.btnUpdateProfilePM);

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPM = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(intentPM);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (male.isChecked()){
                    gender = "Male";
                }else {
                    gender = "Female";
                }

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID = dbHandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "User Added. User ID: "+newID, Toast.LENGTH_SHORT).show();

                Intent intentPM = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(intentPM);

                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(true);
                female.setChecked(false);

            }
        });
    }
}
