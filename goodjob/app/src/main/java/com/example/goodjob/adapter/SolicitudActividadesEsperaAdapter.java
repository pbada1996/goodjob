package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.classes.Actividad;

import java.util.List;

public class SolicitudActividadesEsperaAdapter extends RecyclerView.Adapter<SolicitudActividadesEsperaAdapter.SolicitudActividadesEsperaViewHolder> {

    List<Actividad> actividades;

    public SolicitudActividadesEsperaAdapter(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    @NonNull
    @Override
    public SolicitudActividadesEsperaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_solicitud_actividades_espera, viewGroup, false);
        return new SolicitudActividadesEsperaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudActividadesEsperaViewHolder vh, int i) {
        Actividad a = actividades.get(i);
        vh.actividad.setText(a.getTitle());
        vh.empresa.setText(a.getAuthor());
        vh.fechaRegistro.setText(a.getCreationDate());
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    class SolicitudActividadesEsperaViewHolder extends RecyclerView.ViewHolder {

        private TextView actividad, empresa, fechaRegistro;

        private SolicitudActividadesEsperaViewHolder(@NonNull View v) {
            super(v);
            actividad = v.findViewById(R.id.tvActividadNombreSolicitud);
            empresa = v.findViewById(R.id.tvActividadEmpresaSolicitud);
            fechaRegistro = v.findViewById(R.id.tvActividadFechaRegistroSolicitud);
        }
    }
}
