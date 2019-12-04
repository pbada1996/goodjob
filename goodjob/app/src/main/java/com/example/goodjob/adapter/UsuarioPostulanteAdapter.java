package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.R;
import com.example.goodjob.classes.UsuarioPostulante;
import com.example.goodjob.viewholder.UsuarioPostulanteViewHolder;

import java.util.List;

public class UsuarioPostulanteAdapter extends RecyclerView.Adapter<UsuarioPostulanteViewHolder> {

    private List<UsuarioPostulante> postulantes;
    private OnUsuarioPostulanteListener onUsuarioPostulanteListener;

    public UsuarioPostulanteAdapter(List<UsuarioPostulante> postulantes, OnUsuarioPostulanteListener onUsuarioPostulanteListener) {
        this.postulantes = postulantes;
        this.onUsuarioPostulanteListener = onUsuarioPostulanteListener;
    }

    @NonNull
    @Override
    public UsuarioPostulanteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.usuario_postulante_item,
                viewGroup, false);

        return new UsuarioPostulanteViewHolder(view, onUsuarioPostulanteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioPostulanteViewHolder uvh, int posicion) {
        String nombre = postulantes.get(posicion).getNombre();
        if (nombre.length() > 11)
            nombre = nombre.substring(0, 11);
        uvh.nombre.setText(nombre);
        uvh.reputacion.setText(String.valueOf(postulantes.get(posicion).getReputacion()));
        uvh.estado.setText(postulantes.get(posicion).getEstado());
    }

    @Override
    public int getItemCount() {
        return postulantes.size();
    }

    public interface OnUsuarioPostulanteListener {
        void onAceptarClick(int posicion);

        void onRechazarClick(int posicion);

        void onPostulanteClick(int posicion);
    }
}