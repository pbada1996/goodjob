package com.example.goodjob.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.example.goodjob.adapter.SolicitudEmpresaAdapter;
import com.example.goodjob.classes.Empresa;
import com.example.goodjob.classes.ValidSession;
import com.example.goodjob.interfaces.OnSolicitudEmpresaListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaEmpresasEsperaFragment extends Fragment implements OnSolicitudEmpresaListener {

    private RecyclerView rvSolicitudes;
    private List<Empresa> empresas;

    public ListaEmpresasEsperaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_empresas_espera, container, false);
        setRecyclerView(view);
        empresas = new ArrayList<>();
        listarEmpresasEnEspera();
        return view;
    }

    private void setRecyclerView(View v) {
        rvSolicitudes = v.findViewById(R.id.rvSolicitudesEmpresasEspera);
        rvSolicitudes.setLayoutManager(new LinearLayoutManager(v.getContext()));
        rvSolicitudes.setHasFixedSize(true);
    }

    private void listarEmpresasEnEspera() {
        String url = ValidSession.IP + "/ws_listarSolicitudesEmpresa.php";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Empresa empresa = Empresa.cargarDatosDesdeJson(object);
                        empresas.add(empresa);
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
        Volley.newRequestQueue(getContext()).add(request);
    }

    private void cargarAdapter() {
        SolicitudEmpresaAdapter adapter = new SolicitudEmpresaAdapter(empresas, this);
        rvSolicitudes.setAdapter(adapter);
    }

    @Override
    public void onSolicitudEmpresaClick(int posicion) {
        Empresa empresa = empresas.get(posicion);
        Bundle bundle = new Bundle();
        bundle.putParcelable("empresa", empresa);
        Fragment detalle = new SolicitudEmpresaDetalleFragment();
        detalle.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.containerFragments, detalle)
                .commit();
    }
}
