package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.goodjob.R;

public class UsuarioParticipanteViewHolder extends RecyclerView.ViewHolder {

    public TextView nombreUsuarioParticipante;
    public TextView reputacionPromedio;

    public UsuarioParticipanteViewHolder(@NonNull View itemView)
    {
        super(itemView);
        nombreUsuarioParticipante = itemView.findViewById(R.id.tvNombreUsuarioParticipante);
        reputacionPromedio = itemView.findViewById(R.id.tvReputacionPromedio);
    }
}
