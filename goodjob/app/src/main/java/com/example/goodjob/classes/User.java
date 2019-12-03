package com.example.goodjob.classes;

import org.json.JSONObject;

public class User {

    private Integer id;
    private String url_foto;
    private String nombres;
    private String paterno;
    private String materno;
    private String dni;
    private String fechaNacimiento;
    private String celular;
    private String correo;
    private String direccion;
    private String password;
    private String fechaRegistro;
    private double reputacionPuntos;
    private Integer cantidadVotos;
    private Integer estado;
    private String numeroTarjeta;
    private String genero;
    private String estadoCivil;
    private String cv;
    private String distrito;
    private String linkFb;
    private String linkLd;
    private String tipoUsuario;
    private Integer puntaje;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getReputacionPuntos() {
        return reputacionPuntos;
    }

    public void setReputacionPuntos(double reputacionPuntos) {
        this.reputacionPuntos = reputacionPuntos;
    }

    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getLinkFb() {
        return linkFb;
    }

    public void setLinkFb(String linkFb) {
        this.linkFb = linkFb;
    }

    public String getLinkLd() {
        return linkLd;
    }

    public void setLinkLd(String linkLd) {
        this.linkLd = linkLd;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public void loadUserDataFromJsonObject(JSONObject jsonObject) {
        this.id = jsonObject.optInt("id_usuario");
        this.url_foto = jsonObject.optString("url_foto");
        this.nombres = jsonObject.optString("nombre");
        this.paterno = jsonObject.optString("paterno");
        this.materno = jsonObject.optString("materno");
        this.dni = jsonObject.optString("dni");
        this.fechaNacimiento = jsonObject.optString("fecha_nacimiento");
        this.celular = jsonObject.optString("celular");
        this.correo = jsonObject.optString("correo");
        this.direccion = jsonObject.optString("direccion");
        this.fechaRegistro = jsonObject.optString("fecha_registro");
        this.reputacionPuntos = jsonObject.optDouble("reputacion_ptos");
        this.cantidadVotos = jsonObject.optInt("cantidad_votos");
        this.estado = jsonObject.optInt("estado");
        this.numeroTarjeta = jsonObject.optString("numero_tarjeta");
        this.genero = jsonObject.optString("genero");
        this.estadoCivil = jsonObject.optString("estado_civil");
        this.cv = jsonObject.optString("cv");
        this.distrito = jsonObject.optString("distrito");
        this.linkFb = jsonObject.optString("link_fb");
        this.linkLd = jsonObject.optString("link_linkedin");
        this.tipoUsuario = jsonObject.optString("tipo_usuario");
        this.puntaje = jsonObject.optInt("puntaje");
    }
}