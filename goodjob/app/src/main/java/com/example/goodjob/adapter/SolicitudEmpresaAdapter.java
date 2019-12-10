package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.classes.Empresa;

import java.util.List;

public class SolicitudEmpresaAdapter extends RecyclerView.Adapter<SolicitudEmpresaAdapter.SolicitudEmpresaViewHolder> {

    private List<Empresa> empresas;

    public SolicitudEmpresaAdapter(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @NonNull
    @Override
    public SolicitudEmpresaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_empresas_espera, viewGroup, false);
        return new SolicitudEmpresaViewHolder(view);
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

    class SolicitudEmpresaViewHolder extends RecyclerView.ViewHolder {

        private TextView empresa, ruc, fechaRegistro;

        private SolicitudEmpresaViewHolder(@NonNull View itemView) {
            super(itemView);
            empresa = itemView.findViewById(R.id.tvEmpresaNombre);
            ruc = itemView.findViewById(R.id.tvRucEmpresa);
            fechaRegistro = itemView.findViewById(R.id.tvEmpresaFechaRegistro);
        }
    }
}
