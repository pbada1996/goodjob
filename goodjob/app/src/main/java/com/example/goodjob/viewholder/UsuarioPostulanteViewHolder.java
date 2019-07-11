package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.adapter.UsuarioPostulanteAdapter;

public class UsuarioPostulanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nombre;
    public TextView reputacion;
    public TextView estado;
    public ImageView aceptar;
    public ImageView rechazar;
    private UsuarioPostulanteAdapter.OnUsuarioPostulanteListener onUsuarioPostulanteListener;

    public UsuarioPostulanteViewHolder(@NonNull View itemView, final UsuarioPostulanteAdapter.OnUsuarioPostulanteListener onUsuarioPostulanteListener)
    {
        super(itemView);

        nombre = itemView.findViewById(R.id.tvNombrePostulante);
        reputacion = itemView.findViewById(R.id.tvReputacionPostulante);
        estado = itemView.findViewById(R.id.tvEstadoPostulante);
        aceptar = itemView.findViewById(R.id.ivAceptar);
        rechazar = itemView.findViewById(R.id.ivRechazar);
        this.onUsuarioPostulanteListener = onUsuarioPostulanteListener;

        itemView.setOnClickListener(this);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUsuarioPostulanteListener.onAceptarClick(getAdapterPosition());
            }
        });

        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUsuarioPostulanteListener.onRechazarClick(getAdapterPosition());
            }
        });
    }

    @Override
    public void onClick(View view)
    {
        onUsuarioPostulanteListener.onPostulanteClick(getAdapterPosition());
    }
}
