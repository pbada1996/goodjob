package com.example.goodjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// this activity only translates to the main one.
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
