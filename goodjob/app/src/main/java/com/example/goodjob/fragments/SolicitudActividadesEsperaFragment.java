package com.example.goodjob.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.R;
import com.example.goodjob.adapter.SolicitudActividadesEsperaAdapter;
import com.example.goodjob.classes.Actividad;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SolicitudActividadesEsperaFragment extends Fragment {

    private RecyclerView rvSolicitudActividades;
    private List<Actividad> actividades;

    public SolicitudActividadesEsperaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_solicitud_actividades_espera, container, false);
        setRecyclerView(v);
        listarActividadesEnEspera(v);
        return v;
    }

    private void setRecyclerView(View v) {
        rvSolicitudActividades = v.findViewById(R.id.rvSolicitudActividadesEspera);
        rvSolicitudActividades.setLayoutManager(new LinearLayoutManager(v.getContext()));
        rvSolicitudActividades.setHasFixedSize(true);
        actividades = new ArrayList<>();
    }

    private void listarActividadesEnEspera(View v) {
        String url = ValidSession.IP + "/ws_listarSolicitudesActividades.php";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    JSONObject json;
                    Actividad a;
                    for (int i = 0; i < array.length(); i++) {
                        json = array.getJSONObject(i);
                        a = Actividad.loadActivityDataFromJsonObject(json);
                        actividades.add(a);
                    }
                    cargarAdapter();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        Volley.newRequestQueue(v.getContext()).add(request);
    }

    private void cargarAdapter() {
        SolicitudActividadesEsperaAdapter adapter = new SolicitudActividadesEsperaAdapter(actividades);
        rvSolicitudActividades.setAdapter(adapter);
    }
}
