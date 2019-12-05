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
import com.example.goodjob.classes.ValidSession;

public class ListadoActividadEmpresaEstadoFragment extends Fragment {

    private RecyclerView rvActividades;
    private Integer estado =  null;

    public ListadoActividadEmpresaEstadoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado_actividad_empresa_estado, container, false);

        Bundle bundle = this.getArguments();
        estado = bundle.getInt("estado");

        setRecycler(view);
        cargarData();

        return view;
    }

    private void setRecycler(View view) {
        rvActividades = view.findViewById(R.id.rvActividadesEmpresa);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rvActividades.setLayoutManager(llm);
        rvActividades.setHasFixedSize(true);
    }

    private void cargarData() {
        String url = ValidSession.IP + "ws_listarActividadesEmpresaPorEstado.php?id_empresa="
                + ValidSession.empresaLogueada.getId() + "&estado=" + estado;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(request);
    }
}
