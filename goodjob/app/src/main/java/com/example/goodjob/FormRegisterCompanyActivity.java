package com.example.goodjob;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class FormRegisterCompanyActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    private Button btnRegistrar,btnCancelar;
    private EditText tvrazonsocial ,
            tvruc,tvcelularC,
            tvpasS,tvpassdos;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    Date date = new Date();
    String fecharegistro = dateFormat.format(date);

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register_company);

        tvrazonsocial = (EditText) findViewById(R.id.txtrazonsocialR);
        tvruc = (EditText) findViewById(R.id.txtrucR);
        tvcelularC =(EditText) findViewById(R.id.txtcelularRC);
        tvpasS = (EditText) findViewById(R.id.txtpassRC);
        tvpassdos = (EditText) findViewById(R.id.txtpassRCdos);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnCancelar  =  (Button) findViewById(R.id.btnCancelar);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargarWebServiceRegistrarCompany();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SelectedUserActivity.class);
                startActivity(intent);
            }
        });
        handleSSLHandshake();
    }

    private void CargarWebServiceRegistrarCompany() {
        String url = ValidSession.IP + "/WS_RegistrarEmpresa.php?ErazonSocial="+tvrazonsocial.getText().toString()+"&"+
                "Eruc="+tvruc.getText().toString()+"&"+
                "Ecelular="+tvcelularC.getText().toString()+"&"+
                "Epass="+tvpasS.getText().toString()+"&"+
                "EfechaRegistro="+fecharegistro+"&"+
                "Eestado=1";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"Oh! será el fin del hombre araña?"+ error.toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Te has Registrado con Exito",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }

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
