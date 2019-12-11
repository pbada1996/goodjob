package com.example.goodjob.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.R;
import com.example.goodjob.classes.Actividad;

public class SolicitudActividadesEsperaDetalleFragment extends Fragment {

    private Actividad actividad;
    /* TODO 2.1 aqui declaras los views del layout.
        Ejemplo: private TextView fechaRegistro;
    * */

    public SolicitudActividadesEsperaDetalleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_solicitud_actividades_espera_detalle, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null)
            actividad = bundle.getParcelable("actividad");
        mapearViews(v);
        mostrarDatos(actividad);
        return v;
    }

    private void mapearViews(View v) {
        /* TODO 2.2 aqui haces los findViewById();
            Ejemplo: fechaRegistro = v.findViewById(R.id.tvFechaRegistro);
        * */
    }

    private void mostrarDatos(Actividad a) {
        /* TODO 2.3 y aca haces los setText para mostrar la info en el layout.
            Ejemplo: fechaRegistro.setText(a.getCreationDate());
        * */
    }

    /* TODO 2.4 este solo es un recordatorio para que borres todos los TODO(2.0 - 2.4)
        una vez termines.
     * */

}
