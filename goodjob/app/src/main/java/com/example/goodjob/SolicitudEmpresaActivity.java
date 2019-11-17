package com.example.goodjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.classes.ValidSession;

import java.util.HashMap;
import java.util.Map;

public class SolicitudEmpresaActivity extends AppCompatActivity {

    private EditText nombreComercial, ruc, telefono,
            direccion, razonSocial, correo, codigoPostal;
    private CheckBox terminos, politicas;
    private Spinner distritos;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_empresa);

        inicializarViews();
        establecerAdapterSpinnerDistritos();
        asinarEventoClickBotonEnviar();
    }

    private void inicializarViews(){
        nombreComercial = findViewById(R.id.etNombreComercial);
        ruc = findViewById(R.id.etRuc);
        telefono = findViewById(R.id.etTelefonoEmpresa);
        direccion = findViewById(R.id.etDireccionEmpresa);
        razonSocial = findViewById(R.id.etRazonSocial);
        correo = findViewById(R.id.etCorreoEmpresa);
        codigoPostal = findViewById(R.id.etCodigoPostal);
        terminos = findViewById(R.id.chkTerminos);
        politicas = findViewById(R.id.chkPoliticas);
        distritos = findViewById(R.id.spinnerDistritoEmpresa);
        enviar = findViewById(R.id.btnSolicitarEmpresa);
    }

    private void establecerAdapterSpinnerDistritos(){
        ArrayAdapter<CharSequence> adapterDistritos =
                ArrayAdapter.createFromResource(this,
                        R.array.distritos_array,
                        R.layout.item_spinner_publicar_actividad);
        distritos.setAdapter(adapterDistritos);
    }

    private void asinarEventoClickBotonEnviar(){
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = ValidSession.IP + "/ws_solicitudEmpresa.php";
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SolicitudEmpresaActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SolicitudEmpresaActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("nombre_comercial", nombreComercial.getText().toString());
                        params.put("ruc", ruc.getText().toString());
                        params.put("telefono", telefono.getText().toString());
                        params.put("direccion", direccion.getText().toString());
                        params.put("razon_social", razonSocial.getText().toString());
                        params.put("correo", correo.getText().toString());
                        params.put("codigo_postal", codigoPostal.getText().toString());
                        params.put("id_distrito", String.valueOf(distritos.getSelectedItemId()));
                        return params;
                    }
                };
                Volley.newRequestQueue(getApplicationContext()).add(request);
            }
        });
    }

}
