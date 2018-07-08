package com.example.sonja.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sonja.ui.aws.AWSLoginModel;

public class RegistrierungStep3 extends AppCompatActivity implements View.OnClickListener {

    Button btnWeiter3;

    private static final String SHARED_PREFERENCE = "SavedValues";
    private static final String PREFERENCE_SIGNUP_USER_EMAIL = "signupUserEmail";
    private static final String PREFERENCE_SIGNUP_USER_USERNAME = "signupUserUsername";
    private static final String PREFERENCE_SIGNUP_USER_PASSWORD = "signupUserPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung_step3);

        // Buttons OnClickListener
        btnWeiter3 = findViewById(R.id.btnWeiter3);
        btnWeiter3.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnWeiter3:
                SharedPreferences sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCE, this.MODE_PRIVATE);
                String test = sharedPreferences.getString(PREFERENCE_SIGNUP_USER_EMAIL, "");

                Log.d("register email", "email" + test);
                Log.d("asdasdas","asdasd" + sharedPreferences.getString(PREFERENCE_SIGNUP_USER_EMAIL, ""));

                // auf Registrierungsscreen Ende weiterleiten
                Intent intent = new Intent(this, RegistrierungEnde.class);
                startActivity(intent);
                this.finish();
        }
    }
}


