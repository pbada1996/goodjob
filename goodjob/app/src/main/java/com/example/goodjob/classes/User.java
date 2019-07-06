package com.example.goodjob.classes;

import org.json.JSONObject;

public class User {

    /* TODO: estoy mapeando al usuario, al igual que en la clase de actividad,
     *  si es que me estoy olvidado de algún campo, sientanse libre de agregarlo.
     */

    private Integer id;
    private String name;
    private String surname;
    private String maternalFamilyName;
    private String dni;
    private String passport;
    private String birthDate;
    private String cellphone;
    private Integer professionalProfile; // este puede ser el id de otra clase/tabla :thinking:
    private String email;
    private Integer idDistrito;
    private String address;
    private String password;
    private Integer score;
    private String accountCreationDate;
    private Integer availableActivities; // por defecto cada usuario tendrá 1 actividad disponible
    // para poder aplicar a las diferentes actividades.
    private Integer availablePosts; // la cantidad de actividades que se pueden publicar
    private Double reputacionPuntos;
    private Integer cantidadVotos;
    private boolean premium;
    private Integer status;

    public User() {}

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(String accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMaternalFamilyName() {
        return maternalFamilyName;
    }

    public void setMaternalFamilyName(String maternalFamilyName) {
        this.maternalFamilyName = maternalFamilyName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getProfessionalProfile() {
        return professionalProfile;
    }

    public void setProfessionalProfile(Integer professionalProfile) {
        this.professionalProfile = professionalProfile;
    }

    public Integer getAvailableActivities() {
        return availableActivities;
    }

    public void setAvailableActivities(Integer availableActivities) {
        this.availableActivities = availableActivities;
    }

    public Integer getAvailablePosts() {
        return availablePosts;
    }

    public void setAvailablePosts(Integer availablePosts) {
        this.availablePosts = availablePosts;
    }

    public Double getReputacionPuntos() {
        return reputacionPuntos;
    }

    public void setReputacionPuntos(Double reputacionPuntos) {
        this.reputacionPuntos = reputacionPuntos;
    }

    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void loadUserDataFromJsonObject(JSONObject jsonObject)
    {
        this.id = jsonObject.optInt("idUsuario");
        this.name = jsonObject.optString("Unombre");
        this.surname = jsonObject.optString("UPaterno");
        this.maternalFamilyName = jsonObject.optString("UMaterno");
        this.dni = jsonObject.optString("Udni");
        this.passport = jsonObject.optString("Upasaporte");
        this.birthDate = jsonObject.optString("UfechaNacimiento");
        this.cellphone = jsonObject.optString("Ucelular");
        this.password = jsonObject.optString("Upass");
        this.professionalProfile = jsonObject.optInt("idPerfilP");
        this.email = jsonObject.optString("Ucorreo");
        this.idDistrito = jsonObject.optInt("idDistrito");
        this.address = jsonObject.optString("Udireccion");
        this.score = jsonObject.optInt("puntaje");
        this.accountCreationDate = jsonObject.optString("UfechaRegistro");
        this.availableActivities = jsonObject.optInt("actividades_disponibles");
        this.availablePosts = jsonObject.optInt("publicaciones_disponibles");
        this.reputacionPuntos = jsonObject.optDouble("reputacion_ptos");
        this.cantidadVotos = jsonObject.optInt("cantidad_votos");
        Integer checkingPremiun = jsonObject.optInt("idTipoPremiun");
        this.premium = checkingPremiun != null; // pay attention here, might a bug occur
        this.status = jsonObject.optInt("Uestado");
    }
}
