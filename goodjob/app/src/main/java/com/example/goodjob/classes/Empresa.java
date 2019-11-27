package com.example.goodjob.classes;

import org.json.JSONObject;

public class Empresa {

    private Integer id;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String telefono;
    private String correo;
    private String direccion;
    private String fechaRegistro;
    private String codigoPostal;
    private String password;
    private String distrito;
    private Integer numeroActividades; // publicadas me imagino, right ?
    private Integer estado;

    public static Empresa cargarDatosDesdeObjetoJson(JSONObject data) {

        Empresa empresa = new Empresa();
        empresa.setId(data.optInt("id"));

        return empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getNumeroActividades() {
        return numeroActividades;
    }

    public void setNumeroActividades(Integer numeroActividades) {
        this.numeroActividades = numeroActividades;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
