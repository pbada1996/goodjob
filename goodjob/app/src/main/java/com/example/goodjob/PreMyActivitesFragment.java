package com.example.goodjob;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.goodjob.classes.ValidSession;

public class PreMyActivitesFragment extends Fragment {

    private Button misPostulaciones;
    private Button misPublicaciones;

    public PreMyActivitesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pre_my_activites, container, false);

        mapearCampos(view);

        misPostulaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getFragmentManager().beginTransaction().replace(R.id.containerFragments, new EstadoMisActividadesFragment()).commit();
            }
        });

        misPublicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (ValidSession.usuarioLogueado.getId() == 1)
                    getFragmentManager().beginTransaction().replace(R.id.containerFragments, new EstadoMisPublicacionesFragment()).commit();
                else
                    Toast.makeText(getContext(), "Debe ser usuario premium para acceder", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void mapearCampos(View view)
    {
        misPostulaciones = view.findViewById(R.id.btnMisPostulaciones);
        misPublicaciones = view.findViewById(R.id.btnMisPublicaciones);
    }
}
