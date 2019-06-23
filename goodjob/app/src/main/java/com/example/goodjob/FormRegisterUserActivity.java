package com.example.goodjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormRegisterUserActivity extends AppCompatActivity {
    private Button btnRegister,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register_user);

        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btn_Cancel);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Te has Registrado con Exito",Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SelectedUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
