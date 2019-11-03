package com.example.goodjob;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.example.goodjob.util.DatePickerFragment;

import java.util.regex.Pattern;

public class PublicarActividadActivity extends AppCompatActivity {

    private EditText nombreActividad;
    private EditText descripcionActividad;
    private EditText fechaFin;
    private EditText cantidadParticipantes;
    private EditText recompensa;
    private Button publicarActividad;
    private TextInputLayout tilNombreActividad, tilDescripcionActividad,
            tilFecha, tilParticipantesRequeridos;

    private final int CAMPO_VACIO = 0;
    final int NOMBRE_ACTIVIDAD_TOPE_LONGITUD = 30;
    final int DESCRIPCION_ACTIVIDAD_TOPE_LONGITUD = 140;
    final int PARTICIPANTES_MINIMOS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_actividad);

        mapearCampos();
        establecerEventosDeChekeoDeCampos();
        asignarEventoDeClickParaLaFecha();
        asignarEventoDeClickEnBotonPublicarActividad();
    }

    private void mapearCampos() {
        nombreActividad = findViewById(R.id.txtNombreActividad);
        descripcionActividad = findViewById(R.id.txtDescripcionActividad);
        fechaFin = findViewById(R.id.txtFechaFin);
        cantidadParticipantes = findViewById(R.id.txtCantidadIntegrantes);
        recompensa = findViewById(R.id.txtRecompensa);
        publicarActividad = findViewById(R.id.btnPublicar);
        tilNombreActividad = findViewById(R.id.tilNombreActividad);
        tilDescripcionActividad = findViewById(R.id.tilDescripcionActividad);
        tilFecha = findViewById(R.id.tilFecha);
        tilParticipantesRequeridos = findViewById(R.id.tilCantidadIntegrantes);
    }

    private void asignarEventoDeClickEnBotonPublicarActividad() {
        publicarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validarDatos()) {
                    return;
                }

                String fin = fechaFin.getText().toString();
                String[] format = fin.split("/");
                fin = format[2] + "-" + format[1] + "-" + format[0];

                String url = ValidSession.IP + "/ws_publicarActividad.php?titulo='" + nombreActividad.getText().toString()
                        + "'&descripcion='" + descripcionActividad.getText().toString() + "'&id_usuario=" + ValidSession.usuarioLogueado.getId()
                        + "&fecha_fin='" + fin + "'&participantes_requeridos=" + Integer.valueOf(cantidadParticipantes.getText().toString())
                        + "&recompensa=" + Double.valueOf(recompensa.getText().toString());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(PublicarActividadActivity.this, MainActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
            }
        });
    }

    private boolean validarDatos() {
        return esNombreActividadValido(nombreActividad.getText().toString())
                && esDescripcionValida(descripcionActividad.getText().toString())
                && esFechaValida(fechaFin.getText().toString())
                && esCantidadParticipantesValida(cantidadParticipantes.getText().toString());
    }

    private void establecerEventosDeChekeoDeCampos() {
        nombreActividad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                esNombreActividadValido(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        descripcionActividad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                esDescripcionValida(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        cantidadParticipantes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                esCantidadParticipantesValida(String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void asignarEventoDeClickParaLaFecha(){
        fechaFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
            }
        });
    }

    private boolean esNombreActividadValido(String nombreActividad) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombreActividad).matches()
                || nombreActividad.length() > NOMBRE_ACTIVIDAD_TOPE_LONGITUD
                || nombreActividad.trim().length() == CAMPO_VACIO) {
            tilNombreActividad.setError("Nombre invalido");
            return false;
        }
        tilNombreActividad.setError(null);
        return true;
    }

    private boolean esDescripcionValida(String descripcionActividad) {
        if (descripcionActividad.length() > DESCRIPCION_ACTIVIDAD_TOPE_LONGITUD) {
            tilDescripcionActividad.setError("Descripción muy larga");
            return false;
        } else if (descripcionActividad.trim().length() == CAMPO_VACIO) {
            tilDescripcionActividad.setError("Ingrese una descripción");
            return false;
        }
        tilDescripcionActividad.setError(null);
        return true;
    }

    private boolean esFechaValida(String fecha){
        if (fecha.length() == CAMPO_VACIO){
            tilFecha.setError("Ingrese una fecha");
            return false;
        }
        tilFecha.setError(null);
        return true;
    }

    private boolean esCantidadParticipantesValida(String cantidadParticipantes){
        if (cantidadParticipantes.trim().length() == CAMPO_VACIO){
            tilParticipantesRequeridos.setError("Ingrese cantidad de participantes");
            return false;
        } else if (Integer.valueOf(cantidadParticipantes) < PARTICIPANTES_MINIMOS){
            tilParticipantesRequeridos.setError("El mínimo de participantes es 2");
            return false;
        } else if (!cantidadParticipantes.trim().matches("^[0-9]+$")){
            tilParticipantesRequeridos.setError("Solo se admiten números");
            return false;
        }
        tilParticipantesRequeridos.setError(null);
        return true;
    }
}
