package com.example.goodjob.classes;

import org.json.JSONObject;

public class UsuarioPostulante {

    private Integer id;
    private String nombre;
    private Double reputacion;
    private String estado;

    public static UsuarioPostulante cargarDesdeJsonObject(JSONObject data) {
        UsuarioPostulante postulante = new UsuarioPostulante();
        postulante.id = data.optInt("id");
        postulante.nombre = data.optString("nombre");
        Double reputacion_ptos = data.optDouble("reputacion_ptos");
        Integer cantidad_votos = data.optInt("cantidad_votos");
        Integer estado = data.optInt("estado");

        if (cantidad_votos == 0)
            postulante.reputacion = 0.0;
        else
            postulante.reputacion = reputacion_ptos / cantidad_votos;

        switch (estado) {
            case 1:
                postulante.estado = "En Espera";
                break;
            case 2:
                postulante.estado = "Aceptado";
                break;
            case 3:
                postulante.estado = "Rechazado";
                break;
        }

        return postulante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getReputacion() {
        return reputacion;
    }

    public void setReputacion(Double reputacion) {
        this.reputacion = reputacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}