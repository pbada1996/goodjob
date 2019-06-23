package com.example.goodjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectedUserActivity extends AppCompatActivity {
    private TextView tvuser,tvcompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        tvuser = findViewById(R.id.TvUser);
        tvcompany = findViewById(R.id.TvCompany);

        tvuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormRegisterUserActivity.class);
                startActivity(intent);
            }
        });

        tvcompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormRegisterCompanyActivity.class);
                startActivity(intent);
            }
        });
    }
}
