package com.example.goodjob.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.goodjob.R;

public class SelectedUserActivity extends AppCompatActivity {
    private TextView tvuser, tvcompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        tvuser = findViewById(R.id.TvUser);
        tvcompany = findViewById(R.id.TvCompany);

        tvuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormRegisterUserActivity.class);
                startActivity(intent);
            }
        });

        tvcompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SolicitudEmpresaActivity.class);
                startActivity(intent);
            }
        });
    }
}