package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.classes.Actividad;
import com.example.goodjob.interfaces.OnSolicitudActividadListener;

import java.util.List;

public class SolicitudActividadesEsperaAdapter extends
        RecyclerView.Adapter<SolicitudActividadesEsperaAdapter.SolicitudActividadesEsperaViewHolder> {

    private List<Actividad> actividades;
    private OnSolicitudActividadListener onSolicitudActividadListener;

    public SolicitudActividadesEsperaAdapter(List<Actividad> actividades, OnSolicitudActividadListener onSolicitudActividadListener) {
        this.actividades = actividades;
        this.onSolicitudActividadListener = onSolicitudActividadListener;
    }

    @NonNull
    @Override
    public SolicitudActividadesEsperaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_solicitud_actividades_espera, viewGroup, false);
        return new SolicitudActividadesEsperaViewHolder(v, onSolicitudActividadListener);
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

    class SolicitudActividadesEsperaViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView actividad, empresa, fechaRegistro;
        private OnSolicitudActividadListener onSolicitudActividadListener;

        private SolicitudActividadesEsperaViewHolder(@NonNull View v, OnSolicitudActividadListener onSolicitudActividadListener) {
            super(v);
            actividad = v.findViewById(R.id.tvActividadNombreSolicitud);
            empresa = v.findViewById(R.id.tvActividadEmpresaSolicitud);
            fechaRegistro = v.findViewById(R.id.tvActividadFechaRegistroSolicitud);
            this.onSolicitudActividadListener = onSolicitudActividadListener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onSolicitudActividadListener.onSolicitudActividadClick(getAdapterPosition());
        }
    }
}
