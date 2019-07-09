package com.example.goodjob.classes;

import org.json.JSONObject;

public class UsuarioParticipante {

    private Integer id;
    private String nombre;
    private Double reputacionPromedio;

    public static UsuarioParticipante cargarDataDesdeJsonObject(JSONObject data)
    {
        UsuarioParticipante usuarioParticipante = new UsuarioParticipante();

        usuarioParticipante.id = data.optInt("id");
        usuarioParticipante.nombre = data.optString("nombre");
        Double reputacion_ptos = data.optDouble("reputacion_ptos");
        Integer cantidad_votos = data.optInt("cantidad_votos");
        if (cantidad_votos == 0)
            usuarioParticipante.reputacionPromedio = 0.0;
        else
            usuarioParticipante.reputacionPromedio = reputacion_ptos / cantidad_votos;

        return  usuarioParticipante;
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

    public Double getReputacionPromedio() {
        return reputacionPromedio;
    }

    public void setReputacionPromedio(Double reputacionPromedio) {
        this.reputacionPromedio = reputacionPromedio;
    }
}
