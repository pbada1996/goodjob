package com.example.goodjob.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.goodjob.R;
import com.example.goodjob.adapter.EstadoMisPublicacionesAdapter;
import com.example.goodjob.classes.EstadoMisPublicacionesResponse;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EstadoMisPublicacionesFragment extends Fragment implements EstadoMisPublicacionesAdapter.OnEstadoMisPublicacionesListener {

    private RecyclerView rvMisPublicaciones;
    private List<EstadoMisPublicacionesResponse> publicaciones;

    public EstadoMisPublicacionesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_estado_mis_publicaciones, container, false);

        mapearViews(view);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvMisPublicaciones.setLayoutManager(lm);
        rvMisPublicaciones.setHasFixedSize(true);

        cargarData();

        return view;
    }

    private void mapearViews(View view) {
        rvMisPublicaciones = view.findViewById(R.id.rvMisPublicaciones);
        publicaciones = new ArrayList<>();
    }

    private void cargarData() {
        String url = ValidSession.IP + "/ws_listarMisPublicaciones.php?id_usuario=" + ValidSession.usuarioLogueado.getId();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        EstadoMisPublicacionesResponse publicacion = EstadoMisPublicacionesResponse.cargarDesdeJsonObject(jsonObject);
                        publicaciones.add(publicacion);
                    }
                    cargarAdapter();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }

    private void cargarAdapter() {
        EstadoMisPublicacionesAdapter adapter = new EstadoMisPublicacionesAdapter(publicaciones, this);
        rvMisPublicaciones.setAdapter(adapter);
    }

    @Override
    public void onMisPublicacionesClick(int posicion) {
        Integer id = publicaciones.get(posicion).getId();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);

        Fragment detalle = new DetalleMiPublicacionFragment();
        detalle.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.containerFragments, detalle).commit();
    }
}