package com.example.goodjob.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.goodjob.R;

public class SolicitudEmpresaResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_empresa_resultado);

        Button regresar = findViewById(R.id.btnVolverMenuPrincipal);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SolicitudEmpresaResultadoActivity.this, MainActivity.class));
            }
        });
    }
}