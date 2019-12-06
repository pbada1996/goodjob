package com.example.goodjob.classes;

import org.json.JSONObject;

public class ListadoActividadesEmpresa {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String empresa;
    private String fechaCreacion;
    private String fechaFin;
    private Integer participantesActuales;
    private Integer participantesRequeridos;
    private String urlFoto;
    private String tipoRecompensa;
    private Double recompensa;
    private String distrito;
    private Integer tipoSeleccion;
    private String mensaje;
    private Integer estado;

    public static ListadoActividadesEmpresa crearDesdeJson(JSONObject json) {
        ListadoActividadesEmpresa actividad = new ListadoActividadesEmpresa();
        actividad.id = json.optInt("id");
        actividad.titulo = json.optString("titulo");
        actividad.descripcion = json.optString("descripcion");
        actividad.empresa = json.optString("empresa");
        actividad.fechaCreacion = json.optString("fecha_creacion");
        actividad.fechaFin = json.optString("fecha_fin");
        actividad.participantesActuales = json.optInt("participantes_actuales");
        actividad.participantesRequeridos = json.optInt("participantes_requeridos");
        actividad.urlFoto = json.optString("url_foto");
        actividad.tipoRecompensa = json.optString("tipo_recompensa");
        actividad.recompensa = json.optDouble("recompensa");
        actividad.distrito = json.optString("distrito");
        actividad.tipoSeleccion = json.optInt("tipo_seleccion");
        actividad.mensaje = json.optString("mensaje");
        actividad.estado = json.optInt("estado");
        return actividad;
    }

    public ListadoActividadesEmpresa() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getParticipantesActuales() {
        return participantesActuales;
    }

    public void setParticipantesActuales(Integer participantesActuales) {
        this.participantesActuales = participantesActuales;
    }

    public Integer getParticipantesRequeridos() {
        return participantesRequeridos;
    }

    public void setParticipantesRequeridos(Integer participantesRequeridos) {
        this.participantesRequeridos = participantesRequeridos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(String tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }

    public Double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Double recompensa) {
        this.recompensa = recompensa;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getTipoSeleccion() {
        return tipoSeleccion;
    }

    public void setTipoSeleccion(Integer tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
