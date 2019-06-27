package com.example.goodjob;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class LoginActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    RequestQueue requestQueue;
    JsonRequest jsonRequest;

    private Button btnIngresar;
    private TextView tvregister;
    private EditText txtUser,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtUser =       (EditText)    findViewById(R.id.txtUser);
        txtPass =       (EditText)    findViewById(R.id.txtPass);
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
                iniciarSesion();


                /*String usuario = txtUser.getText().toString();
                 String pass = txtPass.getText().toString();


                RequestLogin loginRequest = new RequestLogin(usuario,pass,respuesta);
                RequestQueue cola = Volley.newRequestQueue(LoginActivity.this);
                cola.add(loginRequest);*/
            }
        });
        handleSSLHandshake();
    }

    private void iniciarSesion() {
        String url="https://192.168.1.108/Conexiones/WS_Login.php?Ucorreo="+txtUser.getText().toString()+"&Upass="+txtPass.getText().toString();
        jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "trme T_T!"+ error.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(), "exito!", Toast.LENGTH_SHORT).show();
    }



    //ESTE CODIGO ES UNICO Y EXCLUSIVAMENTE PARA LAS CERTIFICACIONES DE CONEXION VOLLEY PLEASE NO TOCAR!!!
    //ESTE CODIGO ES UNICO Y EXCLUSIVAMENTE PARA LAS CERTIFICACIONES DE CONEXION VOLLEY PLEASE NO TOCAR!!!
    //ESTE CODIGO ES UNICO Y EXCLUSIVAMENTE PARA LAS CERTIFICACIONES DE CONEXION VOLLEY PLEASE NO TOCAR!!!
    //ESTE CODIGO ES UNICO Y EXCLUSIVAMENTE PARA LAS CERTIFICACIONES DE CONEXION VOLLEY PLEASE NO TOCAR!!!
    @SuppressLint("TrulyRandom")
    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }
}