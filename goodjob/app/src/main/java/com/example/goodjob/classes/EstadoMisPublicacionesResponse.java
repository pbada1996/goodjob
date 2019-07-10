package com.example.goodjob.classes;

import org.json.JSONObject;

public class EstadoMisPublicacionesResponse {

    private Integer id;
    private String titulo;
    private String fecha;
    private Integer postulantes;
    private Integer estado;

    public static EstadoMisPublicacionesResponse cargarDesdeJsonObject(JSONObject data)
    {
        EstadoMisPublicacionesResponse response = new EstadoMisPublicacionesResponse();

        response.id = data.optInt("id");
        response.titulo = data.optString("titulo");
        response.fecha = data.optString("fecha_fin");
        response.postulantes = data.optInt("participantes_actuales");
        response.estado = data.optInt("estado");

        return response;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Integer postulantes) {
        this.postulantes = postulantes;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
