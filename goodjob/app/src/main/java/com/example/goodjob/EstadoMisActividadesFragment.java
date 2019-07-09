package com.example.goodjob;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.adapter.EstadoMisActividadesAdapter;
import com.example.goodjob.classes.EstadoMisActividadesResponse;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class EstadoMisActividadesFragment extends Fragment implements EstadoMisActividadesAdapter.OnEstadoActividadListener {

    private RecyclerView rvEstadoMisActividades;
    private List<EstadoMisActividadesResponse> misActividades = new ArrayList<>();

    public EstadoMisActividadesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_estado_mis_actividades, container, false);

        rvEstadoMisActividades = view.findViewById(R.id.rvMisActividades);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvEstadoMisActividades.setLayoutManager(lm);
        rvEstadoMisActividades.setHasFixedSize(true);

        if (ValidSession.usuarioLogueado != null)
            cargarData(ValidSession.usuarioLogueado.getId());
        else
            cuadroDialogo();

        handleSSLHandshake();
        return view;
    }

    private void cargarData(Integer idUsuario)
    {
        String url = ValidSession.IP + "/ws_listarMisActividades.php?id_usuario=" + idUsuario;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        final EstadoMisActividadesResponse actividad = EstadoMisActividadesResponse.cargarDataDesdeJsonObject(jsonObject);
                        misActividades.add(actividad);
                    }
                    cargarAdaptador();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }

    private void cargarAdaptador()
    {
        EstadoMisActividadesAdapter adapter = new EstadoMisActividadesAdapter(misActividades, this);
        rvEstadoMisActividades.setAdapter(adapter);
    }

    private void cuadroDialogo()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.inicio_sesion);
        builder.setMessage(R.string.iniciar_sesion);
        builder.setPositiveButton(R.string.ok_sesion, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onEstadoActividadClick(int posicion)
    {
        EstadoMisActividadesResponse actividadSeleccionada = misActividades.get(posicion);
        if (actividadSeleccionada.getEstado().equals("Aceptado"))
        {
            // pasando data de fragment a fragment
            Integer id = actividadSeleccionada.getId();
            Fragment actividadAceptada = new ActividadAceptadaFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            actividadAceptada.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.containerFragments, actividadAceptada).commit();
        }
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
