package com.example.goodjob;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ActividadAceptadaFragment extends Fragment {

    public ActividadAceptadaFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actividad_aceptada, container, false);

        Bundle bundle = this.getArguments();
        Integer id = bundle.getInt("id");

        TextView t = view.findViewById(R.id.probando);
        t.setText(id + " ");
        return view;
    }

}
