package com.example.goodjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //DECLARATION THE VARIABLES

    private ImageView imgprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.ImgProfile);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // setting the initial fragment on app start
        Fragment initialFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragments,initialFragment).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new MyActivityFragment();
                    break;
                case R.id.navigation_addactivity:
                    selectedFragment = new AddActivityFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragments,selectedFragment).commit();
            return true;
        }
    };

}
