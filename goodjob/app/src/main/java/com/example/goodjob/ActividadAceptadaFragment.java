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
import com.example.goodjob.adapter.UsuarioParticipanteAdapter;
import com.example.goodjob.classes.ActividadAceptada;
import com.example.goodjob.classes.UsuarioParticipante;
import com.example.goodjob.classes.ValidSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActividadAceptadaFragment extends Fragment implements UsuarioParticipanteAdapter.OnUsuarioParticipanteListener {

    private TextView tituloActividad;
    private TextView nombreAutor;
    private TextView fechaFin;
    private TextView descripcion;
    private TextView recompensa;
    private RecyclerView rvUsuariosParticipantes;
    private List<UsuarioParticipante> usuariosParticipantes;

    public ActividadAceptadaFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actividad_aceptada, container, false);

        tituloActividad = view.findViewById(R.id.tvTituloActividad);
        nombreAutor = view.findViewById(R.id.tvNombreAutorActividad);
        fechaFin = view.findViewById(R.id.tvFechaFinActividad);
        descripcion = view.findViewById(R.id.tvDescriptionActividad);
        recompensa = view.findViewById(R.id.tvRecompensaActividad);
        rvUsuariosParticipantes = view.findViewById(R.id.rvUsuariosParticipantes);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvUsuariosParticipantes.setLayoutManager(lm);
        rvUsuariosParticipantes.setHasFixedSize(true);
        usuariosParticipantes = new ArrayList<>();

        Bundle bundle = this.getArguments();
        Integer idActividad = bundle.getInt("id");

        cargarDatosActividad(idActividad);

        return view;
    }

    private void cargarDatosActividad(final Integer idActividad)
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
                    cargarUsuariosParticipantes(idActividad);
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

    private void setearCamposActividadAceptada(ActividadAceptada actividadAceptada)
    {
        tituloActividad.setText(actividadAceptada.getTitulo());
        nombreAutor.setText(actividadAceptada.getNombreAutor());
        fechaFin.setText(actividadAceptada.getFechaFin());
        descripcion.setText(actividadAceptada.getDescripcion());
        recompensa.setText(actividadAceptada.getRecompensa());
    }

    private void cargarUsuariosParticipantes(Integer idActividad)
    {
        String url = ValidSession.IP + "/ws_listarUsuariosParticipantes.php?id_actividad=" + idActividad;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        UsuarioParticipante participante = UsuarioParticipante.cargarDataDesdeJsonObject(jsonObject);
                        usuariosParticipantes.add(participante);
                    }
                    cargarAdaptador();

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

    private void cargarAdaptador()
    {
        UsuarioParticipanteAdapter adapter = new UsuarioParticipanteAdapter(usuariosParticipantes, this);
        rvUsuariosParticipantes.setAdapter(adapter);
    }

    @Override
    public void onUsuarioParticipanteClick(int posicion)
    {
        UsuarioParticipante usuarioSeleccionado = usuariosParticipantes.get(posicion);

        Bundle bundle = new Bundle();
        bundle.putInt("id", usuarioSeleccionado.getId());
        Fragment perfil = new ProfileFragment();
        perfil.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.containerFragments, perfil).commit();
    }
}
