package com.example.goodjob;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // TODO: programar para checkar el perfil de uno mismo y de los usuarios aceptados

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Integer idUsuario = bundle.getInt("id");
        }
        return view;
    }

}
