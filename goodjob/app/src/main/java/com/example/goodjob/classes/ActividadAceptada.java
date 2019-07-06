package com.example.goodjob.classes;

import org.json.JSONObject;

public class ActividadAceptada {

    private String titulo;
    private String nombreAutor;
    private String fechaFin;
    private String descripcion;
    private String recompensa;

    public static ActividadAceptada cargarDatosDesdeJsonObject(JSONObject data)
    {
        ActividadAceptada actividadAceptada= new ActividadAceptada();

        actividadAceptada.titulo = data.optString("titulo");
        actividadAceptada.nombreAutor = data.optString("nombre_completo");
        actividadAceptada.fechaFin = data.optString("fecha_fin");
        actividadAceptada.descripcion = data.optString("descripcion");
        actividadAceptada.recompensa = data.optString("recompensa");

        return actividadAceptada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }
}
