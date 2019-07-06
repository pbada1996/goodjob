package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.R;
import com.example.goodjob.classes.UsuarioParticipante;
import com.example.goodjob.viewholder.UsuarioParticipanteViewHolder;

import java.util.List;

public class UsuarioParticipanteAdapter extends RecyclerView.Adapter<UsuarioParticipanteViewHolder> {

    private List<UsuarioParticipante> usuariosParticipantes;
    private OnUsuarioParticipanteListener onUsuarioParticipanteListener;

    public UsuarioParticipanteAdapter(List<UsuarioParticipante> usuariosParticipantes, OnUsuarioParticipanteListener onUsuarioParticipanteListener)
    {
        this.usuariosParticipantes = usuariosParticipantes;
        this.onUsuarioParticipanteListener = onUsuarioParticipanteListener;
    }

    @NonNull
    @Override
    public UsuarioParticipanteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.usuario_participante_item,
                viewGroup, false);

        return new UsuarioParticipanteViewHolder(view, onUsuarioParticipanteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioParticipanteViewHolder upvh, int posicion)
    {
        upvh.nombreUsuarioParticipante.setText(usuariosParticipantes.get(posicion).getNombre());
        upvh.reputacionPromedio.setText(String.valueOf(usuariosParticipantes.get(posicion).getReputacionPromedio()));
    }

    @Override
    public int getItemCount() {
        return usuariosParticipantes.size();
    }

    public interface OnUsuarioParticipanteListener
    {
        void onUsuarioParticipanteClick(int posicion);
    }
}
