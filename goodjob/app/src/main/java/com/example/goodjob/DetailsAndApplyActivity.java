package com.example.goodjob;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.classes.Activity;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class DetailsAndApplyActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView author;
    private TextView creationDate;
    private TextView endDate;
    private TextView currentParticipants;
    private TextView requiredParticipants;
    private ImageView photo;
    private Button moreInfo;
    private TextView reward;
    private Activity selectedActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_and_apply);

        title = findViewById(R.id.tvTitle);
        description = findViewById(R.id.tvDescription);
        author = findViewById(R.id.tvAuthorName);
        creationDate = findViewById(R.id.tvCreationDateValue);
        endDate = findViewById(R.id.tvendDateValue);
        currentParticipants = findViewById(R.id.tvCurrent);
        requiredParticipants = findViewById(R.id.tvRequired);
        photo = findViewById(R.id.imgPhoto);
        moreInfo = findViewById(R.id.btnMoreInfo);
        reward = findViewById(R.id.tvReward);

        selectedActivity = getIntent().getExtras().getParcelable("selectedActivity");
        loadData(selectedActivity);

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateStartedSession())
                {
                    if (validateAvailableActivities())
                    {
                        realizarPostulacion(ValidSession.usuarioLogueado.getId(), selectedActivity.getId());
                        cambioDeEstadoBoton();
                        incrementarParticipantes(selectedActivity.getCurrentParticipants() + 1 , selectedActivity.getId());
                        reducirParticipacionesDeUsuario(ValidSession.usuarioLogueado.getId(), ValidSession.usuarioLogueado.getAvailableActivities() - 1);
                        startActivity(new Intent(DetailsAndApplyActivity.this, MainActivity.class));
                        return;
                    }
                    dialogMessage("", R.string.no_more_available_activities,
                            "Comprar más participaciones", SuscriptionActivity.class);
                    return;
                }
                dialogMessage("Inicio de sesión", R.string.should_start_session,
                        "Iniciar sesión!", LoginActivity.class);

            }
        });

        if (ValidSession.usuarioLogueado != null)
            consultarSiYaPostulo(ValidSession.usuarioLogueado.getId(), selectedActivity.getId());
        handleSSLHandshake();
    }

    private void loadData(Activity activity)
    {
        title.setText(activity.getTitle());
        description.setText(activity.getDescription());
        author.setText(activity.getAuthor().substring(0, 20));
        creationDate.setText(formatDate(activity.getCreationDate()));
        endDate.setText(formatDate(activity.getEndDate()));
        currentParticipants.setText("De momento hay " + activity.getCurrentParticipants() + " postulantes");
        requiredParticipants.setText("Se necesitan " + activity.getRequiredParticipants() + " personas");
        photo.setImageResource(R.drawable.placeholder);
        reward.setText(activity.getRewardType() + " : " + activity.getReward());
    }

    private boolean validateStartedSession()
    {
        return ValidSession.usuarioLogueado != null;
    }

    private boolean validateAvailableActivities()
    {
        return ValidSession.usuarioLogueado.getAvailableActivities() > 0;
    }

    private void dialogMessage(String title, Integer message, String positivo, final Class<?> next)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailsAndApplyActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                startActivity(new Intent(DetailsAndApplyActivity.this, next));
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String formatDate(String date)
    {
        String [] fechaEnPartes = date.split("-");
        return fechaEnPartes[2] + "/" + fechaEnPartes[1] + "/" + fechaEnPartes[0];
    }

    private void consultarSiYaPostulo(Integer idUsuario, Integer idActividad)
    {
        String url = ValidSession.IP + "/ws_consultarPostulacionUsuario.php?id_usuario=" + idUsuario + "&id_actividad=" + idActividad;

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Integer id = jsonObject.optInt("id");

                        if (id != null)
                            cambioDeEstadoBoton();
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    private void realizarPostulacion(Integer idUsuario, Integer idActividad)
    {
        String url = ValidSession.IP + "/ws_postulacionActividad.php?id_usuario=" + idUsuario + "&id_actividad=" + idActividad;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailsAndApplyActivity.this);
                builder.setTitle("");
                builder.setMessage(R.string.postulacion_exitosa);
                builder.setPositiveButton("Seguir navegando", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setIcon(android.R.drawable.ic_dialog_info);
                AlertDialog dialog = builder.create();
                dialog.show();
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

    private void cambioDeEstadoBoton()
    {
        moreInfo.setText(R.string.already_in);
        moreInfo.setBackgroundColor(Color.parseColor("#dd2244"));
        moreInfo.setEnabled(false);
    }

    private void incrementarParticipantes(final Integer cantidad, Integer idActividad)
    {
        String url = ValidSession.IP + "/ws_incrementarParticipantesPostulacion.php?cantidad=" + cantidad + "&id_actividad=" + idActividad;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                currentParticipants.setText("De momento hay " + cantidad + " postulantes");
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

    private void reducirParticipacionesDeUsuario(Integer idUsuario, Integer cantidad)
    {
        String url = ValidSession.IP + "/ws_reducirParticipaciones.php?id_usuario=" + idUsuario + "&cantidad=" + cantidad;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                ValidSession.usuarioLogueado.setAvailableActivities(
                        ValidSession.usuarioLogueado.getAvailableActivities() - 1);
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
