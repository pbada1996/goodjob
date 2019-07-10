package com.example.goodjob;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalleMiPublicacionFragment extends Fragment {

    public DetalleMiPublicacionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle_mi_publicacion, container, false);

        Bundle bundle = this.getArguments();
        Integer idActividad = bundle.getInt("id");

        return view;
    }

}
