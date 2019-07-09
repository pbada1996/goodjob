package com.example.goodjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.classes.ValidSession;

public class PublicarActividadActivity extends AppCompatActivity {

    private EditText nombreActividad;
    private EditText descripcionActividad;
    private EditText fechaInicio;
    private EditText fechaFin;
    private EditText cantidadParticipantes;
    private EditText recompensa;
    private Button publicarActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_actividad);

        mapearCampos();

        publicarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String fin = fechaFin.getText().toString();
                String [] format = fin.split("/");
                fin = format[2] + "-" + format[1] + "-" + format[0];

                String url = ValidSession.IP +  "/ws_publicarActividad.php?titulo='" + nombreActividad.getText().toString()
                        + "'&descripcion='" + descripcionActividad.getText().toString() + "'&id_usuario=" + ValidSession.usuarioLogueado.getId()
                        + "&fecha_fin='" + fin + "'&participantes_requeridos=" + Integer.valueOf(cantidadParticipantes.getText().toString())
                        + "&recompensa=" + Double.valueOf(recompensa.getText().toString());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(PublicarActividadActivity.this, MainActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
            }
        });

    }

    private void mapearCampos()
    {
        nombreActividad = findViewById(R.id.txtNombreActividad);
        descripcionActividad = findViewById(R.id.txtDescrionActividad);
        fechaInicio = findViewById(R.id.txtFechaInicio);
        fechaFin = findViewById(R.id.txtFechaFin);
        cantidadParticipantes = findViewById(R.id.txtCantidadIntegrantes);
        recompensa = findViewById(R.id.txtRecompensa);
        publicarActividad = findViewById(R.id.btnPublicar);
    }
}
