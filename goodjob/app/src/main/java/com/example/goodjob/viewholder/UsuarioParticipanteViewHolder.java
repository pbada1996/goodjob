package com.example.goodjob.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.adapter.UsuarioParticipanteAdapter;

public class UsuarioParticipanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nombreUsuarioParticipante;
    public TextView reputacionPromedio;

    private UsuarioParticipanteAdapter.OnUsuarioParticipanteListener onUsuarioParticipanteListener;

    public UsuarioParticipanteViewHolder(@NonNull View itemView, UsuarioParticipanteAdapter.OnUsuarioParticipanteListener onUsuarioParticipanteListener) {
        super(itemView);
        nombreUsuarioParticipante = itemView.findViewById(R.id.tvNombreUsuarioParticipante);
        reputacionPromedio = itemView.findViewById(R.id.tvReputacionPromedio);

        this.onUsuarioParticipanteListener = onUsuarioParticipanteListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onUsuarioParticipanteListener.onUsuarioParticipanteClick(getAdapterPosition());
    }
}