package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodjob.R;

public class UsuarioPostulanteViewHolder extends RecyclerView.ViewHolder {

    public TextView nombre;
    public TextView reputacion;
    public TextView estado;
    public ImageView aceptar;
    public ImageView rechazar;

    public UsuarioPostulanteViewHolder(@NonNull View itemView)
    {
        super(itemView);

        nombre = itemView.findViewById(R.id.tvNombrePostulante);
        reputacion = itemView.findViewById(R.id.tvReputacionPostulante);
        estado = itemView.findViewById(R.id.tvEstadoPostulante);
        aceptar = itemView.findViewById(R.id.ivAceptar);
        rechazar = itemView.findViewById(R.id.ivRechazar);
    }
}
