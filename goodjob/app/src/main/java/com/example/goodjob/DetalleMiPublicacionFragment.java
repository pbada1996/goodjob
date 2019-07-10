package com.example.goodjob;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.adapter.UsuarioPostulanteAdapter;
import com.example.goodjob.classes.ActividadAceptada;
import com.example.goodjob.classes.UsuarioPostulante;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetalleMiPublicacionFragment extends Fragment {

    private TextView titulo;
    private TextView autor;
    private TextView fecha;
    private TextView descripcion;
    private TextView recompensa;
    private RecyclerView rvPostulantes;
    private List<UsuarioPostulante> postulantes;

    public DetalleMiPublicacionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle_mi_publicacion, container, false);

        Bundle bundle = this.getArguments();
        Integer idActividad = bundle.getInt("id");

        mapearViews(view);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvPostulantes.setLayoutManager(lm);
        rvPostulantes.setHasFixedSize(true);

        consultarActividad(idActividad);

        return view;
    }

    private void mapearViews(View view)
    {
        titulo = view.findViewById(R.id.tvTituloMiPublicacion);
        autor = view.findViewById(R.id.tvNombreAutorMiPublicacion);
        fecha = view.findViewById(R.id.tvFechaFinMiPublicacion);
        descripcion = view.findViewById(R.id.tvDescriptionMiPublicacion);
        recompensa = view.findViewById(R.id.tvRecompensaMiPublicacion);
        rvPostulantes = view.findViewById(R.id.rvUsuariosPostulantes);
        postulantes = new ArrayList<>();
    }

    private void consultarActividad(final Integer idActividad)
    {
        String url = ValidSession.IP + "/ws_consultarActividadAceptada.php?id_actividad=" + idActividad;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    ActividadAceptada actividadAceptada = ActividadAceptada.cargarDatosDesdeJsonObject(jsonObject);
                    setearCamposActividadAceptada(actividadAceptada);
                    cargarUsuariosPostulantes(idActividad);
                } catch (JSONException e)
                {
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

    private void setearCamposActividadAceptada(ActividadAceptada aceptada)
    {
        titulo.setText(aceptada.getTitulo());
        autor.setText(aceptada.getNombreAutor());
        fecha.setText(dateFormat(aceptada.getFechaFin()));
        descripcion.setText(aceptada.getDescripcion());
        recompensa.setText(aceptada.getRecompensa());
    }

    private String dateFormat(String fecha)
    {
        String [] f = fecha.split("-");
        return f[2] + "/" + f[1] + "/" + f[0];
    }

    private void cargarUsuariosPostulantes(Integer idActividad)
    {
        String url = ValidSession.IP + "/ws_listarPostulantes.php?id_actividad=" + idActividad;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        UsuarioPostulante postulante = UsuarioPostulante.cargarDesdeJsonObject(jsonObject);
                        postulantes.add(postulante);
                    }
                    cargarAdapter();

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

    private void cargarAdapter()
    {
        UsuarioPostulanteAdapter adapter = new UsuarioPostulanteAdapter(postulantes);
        rvPostulantes.setAdapter(adapter);
    }
}
