package com.example.goodjob.classes;

import org.json.JSONObject;

public class PerfilUsuario {

    private Integer id;
    private String nombre;
    private Integer puntaje;
    private Double reputacion;

    public static PerfilUsuario cargarDataDesdeJsonObject(JSONObject data)
    {
        PerfilUsuario perfilUsuario = new PerfilUsuario();

        perfilUsuario.id = data.optInt("id");
        perfilUsuario.nombre = data.optString("nombre");
        perfilUsuario.puntaje = data.optInt("puntaje");

        Double reputacionTotal = data.optDouble("reputacion_ptos");
        Integer cantidadVotos = data.optInt("cantidad_votos");

        if (cantidadVotos == 0)
            perfilUsuario.reputacion = 0.0;
        else
            perfilUsuario.reputacion = reputacionTotal / cantidadVotos;

        return perfilUsuario;
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

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Double getReputacion() {
        return reputacion;
    }

    public void setReputacion(Double reputacion) {
        this.reputacion = reputacion;
    }
}
