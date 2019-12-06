package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.classes.ListadoActividadesEmpresa;

import java.util.List;

public class ListadoActividadesEmpresaAdapter extends RecyclerView.Adapter<ListadoActividadesEmpresaAdapter.ListadoActividadesEmpresaViewHolder> {

    private List<ListadoActividadesEmpresa> actividades;

    public ListadoActividadesEmpresaAdapter(List<ListadoActividadesEmpresa> actividades) {
        this.actividades = actividades;
    }

    @NonNull
    @Override
    public ListadoActividadesEmpresaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_listado_actividad_empresa, viewGroup, false);
        return new ListadoActividadesEmpresaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListadoActividadesEmpresaViewHolder lvh, int index) {
        ListadoActividadesEmpresa e = actividades.get(index);
        lvh.titulo.setText(e.getTitulo());
        lvh.fechaCreacion.setText(e.getFechaCreacion());
        lvh.fechaFin.setText(e.getFechaFin());
        lvh.distrito.setText(e.getDistrito());
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    class ListadoActividadesEmpresaViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, fechaCreacion, fechaFin, distrito;

        private ListadoActividadesEmpresaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvActividadNombre);
            fechaCreacion = itemView.findViewById(R.id.tvActividadFechaRegistro);
            fechaFin = itemView.findViewById(R.id.tvActividadFechaRealizarse);
            distrito = itemView.findViewById(R.id.tvActividadEmpresa);
        }
    }
}
