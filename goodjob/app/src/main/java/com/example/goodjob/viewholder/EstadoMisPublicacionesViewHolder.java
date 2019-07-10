package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.goodjob.R;

public class EstadoMisPublicacionesViewHolder extends RecyclerView.ViewHolder {

    public TextView titulo;
    public TextView fecha;
    public TextView postulantes;

    public EstadoMisPublicacionesViewHolder(@NonNull View itemView) {
        super(itemView);

        titulo = itemView.findViewById(R.id.tvTituloMisPublicaciones);
        fecha = itemView.findViewById(R.id.tvFechaMisPublicaciones);
        postulantes = itemView.findViewById(R.id.tvCantidadPostulantes);
    }

}
