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
    private String birthDate;
    private String cellphone;
    private String password;
    private Integer professionalProfile; // este puede ser el id de otra clase/tabla :thinking:
    private Integer availableActivities; // por defecto cada usuario tendrá 1 actividad disponible
    // para poder aplicar a las diferentes actividades.
    private Integer availablePosts; // la cantidad de actividades que se pueden publicar
    private boolean premium;
    private Integer status;

    public User() {}

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
        this.birthDate = jsonObject.optString("UfechaNacimiento");
        this.cellphone = jsonObject.optString("Ucelular");
        this.password = jsonObject.optString("Upass");
        this.professionalProfile = jsonObject.optInt("idPerfilP");
        this.availableActivities = 1;
        this.availablePosts = 0;
        this.premium = false;
        this.status = jsonObject.optInt("Uestado");

        // TODO: faltan campos y setear algunos existentes.
    }
}
