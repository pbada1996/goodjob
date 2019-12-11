package com.example.goodjob.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.R;

public class SolicitudActividadesEsperaFragment extends Fragment {

    public SolicitudActividadesEsperaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_solicitud_actividades_espera, container, false);
        return v;
    }

}
