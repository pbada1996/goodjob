package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.classes.Empresa;
import com.example.goodjob.interfaces.OnSolicitudEmpresaListener;

import java.util.List;

public class SolicitudEmpresaAdapter extends RecyclerView.Adapter<SolicitudEmpresaAdapter.SolicitudEmpresaViewHolder> {

    private List<Empresa> empresas;
    private OnSolicitudEmpresaListener onSolicitudEmpresaListener;

    public SolicitudEmpresaAdapter(List<Empresa> empresas, OnSolicitudEmpresaListener onSolicitudEmpresaListener) {
        this.empresas = empresas;
        this.onSolicitudEmpresaListener = onSolicitudEmpresaListener;
    }

    @NonNull
    @Override
    public SolicitudEmpresaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_empresas_espera, viewGroup, false);
        return new SolicitudEmpresaViewHolder(view, onSolicitudEmpresaListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudEmpresaViewHolder v, int i) {
        Empresa e = empresas.get(i);
        v.empresa.setText(e.getNombreComercial());
        v.ruc.setText(e.getRuc());
        v.fechaRegistro.setText(e.getFechaRegistro());
    }

    @Override
    public int getItemCount() {
        return empresas.size();
    }

    class SolicitudEmpresaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView empresa, ruc, fechaRegistro;
        private OnSolicitudEmpresaListener onSolicitudEmpresaListener;

        private SolicitudEmpresaViewHolder(@NonNull View itemView, final OnSolicitudEmpresaListener onSolicitudEmpresaListener) {
            super(itemView);
            empresa = itemView.findViewById(R.id.tvEmpresaNombre);
            ruc = itemView.findViewById(R.id.tvRucEmpresa);
            fechaRegistro = itemView.findViewById(R.id.tvEmpresaFechaRegistro);
            this.onSolicitudEmpresaListener = onSolicitudEmpresaListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onSolicitudEmpresaListener.onSolicitudEmpresaClick(getAdapterPosition());
        }
    }
}
