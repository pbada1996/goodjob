package com.example.goodjob;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.Request.RequestLogin;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity{

    RequestQueue requestQueue;
    JsonRequest jsonRequest;

    private Button btnIngresar;
    private TextView tvregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText txtUser =       (EditText)    findViewById(R.id.txtUser);
        final EditText txtPass =       (EditText)    findViewById(R.id.txtPass);
        tvregister =    (TextView)    findViewById(R.id.TvRegister);
        btnIngresar =   (Button)      findViewById(R.id.btnLogin);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SelectedUserActivity.class);
                startActivity(intent);
            }
        });


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String usuario = txtUser.getText().toString();
                 String pass = txtPass.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("sucess");

                            if (ok){
                                Toast.makeText(getApplicationContext(),"ctrm",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(LoginActivity.this);
                                alerta.setMessage("Fallo al iniciar sesión")
                                        .setNegativeButton("Reintentar",null)
                                        .create().show();
                            }
                        }catch (JSONException e){
                            e.getMessage();

                        }
                    }
                };
                RequestLogin loginRequest = new RequestLogin(usuario,pass,respuesta);
                RequestQueue cola = Volley.newRequestQueue(LoginActivity.this);
                cola.add(loginRequest);


            }
        });
    }
}