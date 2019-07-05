package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.goodjob.R;

public class EstadoMisActividadesViewHolder extends RecyclerView.ViewHolder {

    public TextView titulo;
    public TextView autor;
    public TextView fecha;
    public TextView estado;

    public EstadoMisActividadesViewHolder(@NonNull View itemView)
    {
        super(itemView);

        titulo = itemView.findViewById(R.id.tvTitulo);
        autor = itemView.findViewById(R.id.tvAutor);
        fecha = itemView.findViewById(R.id.tvFecha);
        estado = itemView.findViewById(R.id.tvEstado);
    }
}
