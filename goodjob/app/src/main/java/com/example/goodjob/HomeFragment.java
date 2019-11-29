package com.example.goodjob;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.goodjob.adapter.ActivityAdapter;
import com.example.goodjob.classes.Actividad;
import com.example.goodjob.classes.ValidSession;
import com.example.goodjob.util.Certificado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HomeFragment extends Fragment implements ActivityAdapter.OnActivityListener {

    private RecyclerView activitiesRecycler;
    private List<Actividad> activities;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        activitiesRecycler = view.findViewById(R.id.rvActivityList);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        activitiesRecycler.setLayoutManager(lm);
        activitiesRecycler.setHasFixedSize(true);

        Certificado.handleSSLHandshake();
        loadData();
        return view;
    }

    private void loadData() {
        activities = new ArrayList<>();
        String url = ValidSession.IP + "/ws_listarActividades2.php";

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest jsonRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Actividad actividad = loadActivityDataFromDatabase(jsonObject);
                        activities.add(actividad);
                    }
                    loadAdapter();
                } catch (JSONException e) {
                    Logger.getLogger(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonRequest);
    }

    private Actividad loadActivityDataFromDatabase(JSONObject jsonObject) {
        return Actividad.loadActivityDataFromJsonObject(jsonObject);
    }

    private void loadAdapter() {
        ActivityAdapter adapter = new ActivityAdapter(activities, getContext(), this);
        activitiesRecycler.setAdapter(adapter);
    }

    @Override
    public void onActivityClick(int position) {
        Actividad selectedActivity = activities.get(position);
        Intent details = new Intent(getContext(), DetailsAndApplyActivity.class);
        details.putExtra("selectedActivity", selectedActivity);
        startActivity(details);
    }
}
